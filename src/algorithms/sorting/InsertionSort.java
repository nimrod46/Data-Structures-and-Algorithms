package algorithms.sorting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertionSort {

  public static Integer[] insertionSort(Integer[] array) {
    List<Integer> list = new LinkedList<>(Arrays.asList(array)); //Using linked list so shifting will be efficient
    for (int i = 1; i < list.size(); i++) { //Fixed: i start at i = 1
      if (list.get(i) <= list.get(0)) { //Fixed: duplicate values sort by changing  to "<="
                                        //Checking if current number is suppose to be first
        list.add(0, list.get(i)); //Moving the number to first position
        list.remove(i + 1);
      } else {
        // only sort number smaller than number on the left of it.
        // This is the part of insertion sort that makes it fast
        // if the array is almost sorted.
        if (list.get(i) < list.get(i - 1)) {
          //find where number should go
          for (int j = 1; j < i; j++) {
            if (list.get(i) >= list.get(j - 1) && list.get(i) < list.get(j)) {
              //move number to the correct spot
              list.add(j, list.get(i));
              list.remove(i + 1);
            }
          }
        }
      }
    }
    return list.toArray(new Integer[0]);
  }

  public static void main(String[] args) {
    Integer[] array = {1, 8, 54, 9, 65, 1, 100, 0, 45};
    Arrays.stream(insertionSort(array)).forEach(System.out::println);
  }
}
