package algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {

  public static Integer[] selectionSort(Integer[] array) {
    for (int i = 0; i < array.length; i++) {
      int minValue = array[i];
      int minIndex = i;
      for (int j = i + 1; j < array.length; j++) {
        if (minValue > array[j]) { //Searching min value and it's index
          minValue = array[j];
          minIndex = j;
        }
      }
      int temp = array[i]; //Swapping the min value found
      array[i] = minValue;
      array[minIndex] = temp;
    }
    return array;
  }

  public static void main(String[] args) {
    Integer[] array = {5, 1, 85, 4, 7, 9, 0, 3, 1};
    Arrays.stream(selectionSort(array)).forEach(System.out::println);
  }
}
