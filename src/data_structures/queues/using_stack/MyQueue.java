package data_structures.queues.using_stack;

import java.util.Stack;

public class MyQueue {
  private Stack<Integer> stack = new Stack<>();
  private Stack<Integer> auxiliaryStack = new Stack<>();

  public void enqueue(int value) {
    stack.push(value);
  }

  public int dequeue() {
    fillAuxiliaryStackWithStack();
    int value = auxiliaryStack.pop();
    fillStackWithAuxiliaryStack();
    return value;
  }

  public int peek() {
   fillAuxiliaryStackWithStack();
    int value = auxiliaryStack.peek();
    fillStackWithAuxiliaryStack();
    return value;
  }

  public void printQueue() {
    if (stack.empty()) {
      return;
    }

    fillAuxiliaryStackWithStack();
    Object[] list = auxiliaryStack.toArray();
    for (Object o : list) {
      System.out.print("-->" + o);
    }
    System.out.println();
   fillStackWithAuxiliaryStack();
  }

  private void fillAuxiliaryStackWithStack() {
    while (!stack.isEmpty()) { //Making the "auxiliaryStack" stack as queue of "Stack"
      auxiliaryStack.push(stack.pop());
    }
  }

  private void fillStackWithAuxiliaryStack() {
    while (!auxiliaryStack.isEmpty()) { //Return stack to the original state
      stack.push(auxiliaryStack.pop());
    }
  }


  public static void main(String[] args) {
    MyQueue queue = new MyQueue();
    queue.enqueue(10);
    queue.enqueue(4);
    queue.enqueue(5);
    queue.printQueue();
    queue.dequeue();
    queue.printQueue();
    queue.dequeue();
    queue.printQueue();
  }
}

