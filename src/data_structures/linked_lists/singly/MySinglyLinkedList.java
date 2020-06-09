package data_structures.linked_lists.singly;

public class MySinglyLinkedList {
  private MySinglyLinkedNode head;
  private MySinglyLinkedNode tail;
  private int length;

  public MySinglyLinkedList(int value) {
    head = new MySinglyLinkedNode(value);
    tail = head;
    length = 1;
  }

  public void prepend(int value) {
    head = new MySinglyLinkedNode(value, head);
    length ++;
  }

  public void append(int value) {
    MySinglyLinkedNode newNode = new MySinglyLinkedNode(value);
    tail.setNext(newNode);
    tail = newNode;
    length ++;
  }

  public void printList() {
    if(head == null) {
      return;
    }
    MySinglyLinkedNode currentNode = head;
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

    MySinglyLinkedNode leader = traverseToIndex(index - 1);
    MySinglyLinkedNode nextNode = leader.getNext();

    MySinglyLinkedNode newNode = new MySinglyLinkedNode(value, nextNode);
    leader.setNext(newNode);
    length++;
  }

  public void remove(int index) {
    index = wrapIndex(index);
    if(index == 0) {
      head = head.getNext();
      return;
    }

    MySinglyLinkedNode leader = traverseToIndex(index - 1);
    MySinglyLinkedNode nodeToRemove = leader.getNext();
    leader.setNext(nodeToRemove.getNext());
    length--;
  }

  public void reverse() {
    MySinglyLinkedNode first = head;
    tail = head;
    MySinglyLinkedNode second = first.getNext();
    for (int i = 0; i < length - 1; i++) {
      MySinglyLinkedNode temp = second.getNext();
      second.setNext(first);
      first = second;
      second = temp;
    }
    head.setNext(null);
    head = first;
  }

  public MySinglyLinkedNode traverseToIndex(int index) {
    index = wrapIndex(index);
    MySinglyLinkedNode currentNode = head;
    for (int i = 0; i < index; i++) {
      currentNode = currentNode.getNext();
    }
    return currentNode;
  }

  private int wrapIndex(int index) { //Used for wrapping the given index to make sure it's valid
    return Math.max(Math.min(index, length - 1), 0);
  }

  public MySinglyLinkedNode getHead() {
    return head;
  }

  public MySinglyLinkedNode getTail() {
    return tail;
  }

  public int getLength() {
    return length;
  }

  public static void main(String[] args) {
    MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(5);
    mySinglyLinkedList.append(8);
    mySinglyLinkedList.append(4);
    mySinglyLinkedList.prepend(10);
    mySinglyLinkedList.printList();
    mySinglyLinkedList.insert(2,15);
    mySinglyLinkedList.printList();
    mySinglyLinkedList.remove(100);
    mySinglyLinkedList.remove(2);
    mySinglyLinkedList.printList();
    mySinglyLinkedList.reverse();
    mySinglyLinkedList.printList();
  }
}
