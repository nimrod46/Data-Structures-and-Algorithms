package algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {

  public static Integer[] bubbleSort(Integer[] array) {
    int temp;
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length - 1; j++) {
        if (array[j] > array[j + 1]) {
          temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
    return array;
  }

  public static void main(String[] args) {
    Integer[] array = {8, 1, 56, 4, 7, 1, 87, 0};
    Arrays.stream(bubbleSort(array)).forEach(System.out::println);
  }
}
