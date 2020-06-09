package data_structures.queues.using_linked_list;

import java.util.NoSuchElementException;

public class MyQueue {

  private MySinglyLinkedNode first;
  private MySinglyLinkedNode last;
  private int length;

  public MyQueue() {
    first = null;
    last = null;
    length = 0;
  }

  public int peek() {
    if(first == null) {
      throw new NoSuchElementException();
    }
    return first.getValue();
  }

  public void enqueue(int value) {
    MySinglyLinkedNode newNode = new MySinglyLinkedNode(value);
    if(length == 0) {
      first = newNode;
    }
    else {
      last.setNext(newNode);
    }
    last = newNode;
    length++;
  }

  public void dequeue() {
    if(first == null) {
      throw new NoSuchElementException();
    }
    first = first.getNext();
    length--;
    if(length == 0) {
      last = null;
    }
  }

  public void printQueue() {
    if(first == null) {
      return;
    }
    MySinglyLinkedNode currentNode = first;
    System.out.print(currentNode.getValue());
    currentNode = currentNode.getNext();
    while (currentNode != null) {
      System.out.print("-->" + currentNode.getValue());
      currentNode = currentNode.getNext();
    }
    System.out.println();
  }

  public static void main(String[] args) {
    MyQueue queue = new MyQueue();
    queue.enqueue(3);
    queue.enqueue(5);
    queue.enqueue(5);
    queue.printQueue();
    queue.dequeue();
    queue.printQueue();
    queue.dequeue();
    queue.dequeue();
    queue.printQueue();
  }
}
