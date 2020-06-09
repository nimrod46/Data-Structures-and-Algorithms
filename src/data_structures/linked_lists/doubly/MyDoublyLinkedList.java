package data_structures.linked_lists.doubly;

public class MyDoublyLinkedList {
  private MyDoublyLinkedNode head;
  private MyDoublyLinkedNode tail;
  private int length;

  public MyDoublyLinkedList(int value) {
    head = new MyDoublyLinkedNode(value);
    tail = head;
    length = 1;
  }

  public void prepend(int value) {
    MyDoublyLinkedNode newNode = new MyDoublyLinkedNode(value, null, head);
    head.setPrevious(newNode);
    head = newNode;
    length ++;
  }

  public void append(int value) {
    MyDoublyLinkedNode newNode = new MyDoublyLinkedNode(value, tail, null);
    tail.setNext(newNode);
    tail = newNode;
    length ++;
  }

  public void printList() {
    MyDoublyLinkedNode currentNode = head;
    System.out.print(currentNode.getValue());
    currentNode = currentNode.getNext();
    while (currentNode != null) {
      System.out.print("-->" + currentNode.getValue());
      currentNode = currentNode.getNext();
    }
    System.out.println();
  }

  public void insert(int index, int value) {
    index = wrapIndex(index);
    if (index == 0) {
      prepend(value);
      return;
    }

    if (index == length - 1) {
      append(value);
      return;
    }

    MyDoublyLinkedNode leader = traverseToIndex(index - 1);
    MyDoublyLinkedNode follower = leader.getNext();

    MyDoublyLinkedNode newNode = new MyDoublyLinkedNode(value, leader, follower);
    leader.setNext(newNode);
    follower.setPrevious(newNode);
    length++;
  }

  public void remove(int index) {
    index = wrapIndex(index);
    if(index == 0) {
      head = head.getNext();
      return;
    }

    MyDoublyLinkedNode leader = traverseToIndex(index - 1);
    MyDoublyLinkedNode nodeToRemove = leader.getNext();
    leader.setNext(nodeToRemove.getNext());
    nodeToRemove.getNext().setPrevious(leader);
    length--;
  }

  public MyDoublyLinkedNode traverseToIndex(int index) {
    index = wrapIndex(index);
    MyDoublyLinkedNode currentNode = head;
    for (int i = 0; i < index; i++) {
      currentNode = currentNode.getNext();
    }
    return currentNode;
  }

  private int wrapIndex(int index) { //Used for wrapping the given index to make sure it's valid
    return Math.max(Math.min(index, length - 1), 0);
  }

  public MyDoublyLinkedNode getHead() {
    return head;
  }

  public MyDoublyLinkedNode getTail() {
    return tail;
  }

  public int getLength() {
    return length;
  }

  public static void main(String[] args) {
    MyDoublyLinkedList mySinglyLinkedList = new MyDoublyLinkedList(5);
    mySinglyLinkedList.append(7);
    mySinglyLinkedList.append(4);
    mySinglyLinkedList.prepend(10);
    mySinglyLinkedList.printList();
    mySinglyLinkedList.insert(2,15);
    mySinglyLinkedList.printList();
    mySinglyLinkedList.remove(0);
    mySinglyLinkedList.printList();
  }
}
