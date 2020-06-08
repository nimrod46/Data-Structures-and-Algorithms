package algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

  public static Integer[] mergeSort(Integer[] array) {
    return mergeSort(new ArrayList<>(Arrays.asList(array))).toArray(new Integer[0]);
  }

  public static List<Integer> mergeSort(List<Integer> array) {
    if (array.size() == 1) {
      return array;
    }
    // Split Array in into right and left
    List<Integer> left = array.subList(0, array.size() / 2);
    System.out.println("Splitting left: " + left);
    List<Integer> right = array.subList(array.size() / 2, array.size());
    System.out.println("Splitting Right: " + right);
    return merge(mergeSort(left), mergeSort(right));
  }

  public static List<Integer> merge(List<Integer> left, List<Integer> right) {
    List<Integer> merged = new ArrayList<>();
    int leftIndex = 0;
    int rightIndex = 0;
    while (leftIndex < left.size() && rightIndex < right.size()) { //Keep merging until we done with one of the sides
      if (left.get(leftIndex) <= right.get(rightIndex)) { //Fixed: "<" to "<=", this what makes the merge sort "stable"
        merged.add(left.get(leftIndex));
        leftIndex++;
      } else {
        merged.add(right.get(rightIndex));
        rightIndex++;
      }
    }
    merged.addAll(left.subList(leftIndex, left.size())); //Merging all "leftovers" elements as is because we know they are sorted
    merged.addAll(right.subList(rightIndex, right.size())); //Same
    System.out.println("Merged: " + merged);
    return merged;
  }

  public static void main(String[] args) {
    Integer[] array = {1, 8, 54, 9, 65, 1, 100, 0, 45, 50, 0, 90, 30, 46};
    Arrays.stream(mergeSort(array)).forEach(System.out::println);
  }
}
