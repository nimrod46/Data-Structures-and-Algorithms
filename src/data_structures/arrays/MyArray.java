package data_structures.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is an example of how to right the same code in the course,
 * this is NOT an example of dynamic array in java, for dynamic arrays in java please see {@link ArrayList}
 */
public class MyArray {

  private Object[] data;
  private int capacity;
  private int length;

  public MyArray () {
    capacity = 1;
    length = 0;
    data = new Object[1];
  }

  public Object get(int index) {
    return data[index];
  }

  public void push(Object obj) {
    if(capacity == length) {
      data = Arrays.copyOf(data, capacity * 2);
      capacity *= 2;
    }
    data[length] = obj;
    length++;
  }

  public Object pop() {
    Object popped = data[length - 1];
    data[length - 1] = null;
    length--;
    return popped;
  }

  public Object delete(int index) {
    Object itemToDelete = data[index];
    shiftItems(index);
    return itemToDelete;
  }

  public void shiftItems(int index) {
    for (int i = index; i < length - 1; i++) {
      data[i] = data[i + 1];
    }
    data[length - 1] = null;
    length--;
  }

  public static void main(String[] args) {
    MyArray m = new MyArray();
    m.push("Hello");
    m.push("World");

    for (int i = 0; i < m.length; i++) {
      System.out.println(m.get(i));
    }
  }
}
