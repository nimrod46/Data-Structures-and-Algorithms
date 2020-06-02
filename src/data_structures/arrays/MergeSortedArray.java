package data_structures.arrays;

import java.util.Arrays;

public class MergeSortedArray {

  public static int[] MargeTwoSortedArray(int[] array1, int[] array2) {
    final int[] mergedArray = new int[array1.length + array2.length];
    int j = 0, k = 0;
    for (int i = 0; i < mergedArray.length; i++) {
      if (j != array1.length && (k == array2.length || array1[j] < array2[k])) {
        mergedArray[i] = array1[j];
        j++;
      } else {
        mergedArray[i] = array2[k];
        k++;
      }
    }
    return mergedArray;
  }

  public static void main(String[] args) {
    int[] arr = MargeTwoSortedArray(new int[]{1,1,8,9,10}, new int[]{1,2,8,9,11,15,16});
    Arrays.stream(arr).forEach(System.out::println);
  }
}
