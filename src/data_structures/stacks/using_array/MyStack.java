package data_structures.stacks.using_array;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class MyStack {
  private List<Integer> array = new ArrayList<>();

  public MyStack() {
  }

  public int peak() {
    if(array.size() == 0) {
      throw new EmptyStackException();
    }
    return array.get(this.array.size() - 1);
  }

  public int pop() {
    if(array.size() == 0) {
      throw new EmptyStackException();
    }
    return array.remove(array.size() - 1);
  }

  public void push(int valueToPush) {
    array.add(valueToPush);
  }

  public void printStack() {
    for (int value : array) {
      System.out.println(value);
    }
  }

  public static void main(String[] args) {
    MyStack stack = new MyStack();
    stack.push(5);
    stack.printStack();
    stack.push(3);
    stack.printStack();
    stack.pop();
    stack.printStack();
  }
}
