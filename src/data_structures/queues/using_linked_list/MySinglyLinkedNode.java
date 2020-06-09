package data_structures.queues.using_linked_list;

public class MySinglyLinkedNode {

  private int value;
  private MySinglyLinkedNode next;

  public MySinglyLinkedNode(int value) {
    this.value = value;
    this.next = null;
  }

  public MySinglyLinkedNode(int value, MySinglyLinkedNode next) {
    this.value = value;
    this.next = next;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public MySinglyLinkedNode getNext() {
    return next;
  }

  public void setNext(MySinglyLinkedNode next) {
    this.next = next;
  }
}
