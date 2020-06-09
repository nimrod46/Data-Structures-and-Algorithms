package data_structures.linked_lists.doubly;

public class MyDoublyLinkedNode {

  private int value;
  private MyDoublyLinkedNode previous;
  private MyDoublyLinkedNode next;

  public MyDoublyLinkedNode(int value) {
    this.value = value;
    this.next = null;
  }

  public MyDoublyLinkedNode(int value, MyDoublyLinkedNode previous, MyDoublyLinkedNode next) {
    this.value = value;
    this.next = next;
    this.previous = previous;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public MyDoublyLinkedNode getNext() {
    return next;
  }

  public void setNext(MyDoublyLinkedNode next) {
    this.next = next;
  }

  public MyDoublyLinkedNode getPrevious() {
    return previous;
  }

  public void setPrevious(MyDoublyLinkedNode previous) {
    this.previous = previous;
  }
}
