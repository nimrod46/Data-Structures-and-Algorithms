package data_structures.trees.binary_search_tree;

public class MyBinarySearchTree {

  private MyBinaryNode root;

  public MyBinarySearchTree() {
    root = null;
  }

  public void insert(int value) {
    if(root == null) {
      root = new MyBinaryNode(value);
      return;
    }
    MyBinaryNode currentNode = root;
    while (true) {
      if (currentNode.getValue() > value) {
        if(currentNode.getLeft() == null) {
          currentNode.setLeft(new MyBinaryNode(value));
          return;
        }
        currentNode = currentNode.getLeft();
      } else {
        if(currentNode.getRight() == null) {
          currentNode.setRight(new MyBinaryNode(value));
          return;
        }
        currentNode = currentNode.getRight();
      }
    }
  }

  public MyBinaryNode lookup(int value) {
    if(root == null) {
      return null;
    }
    MyBinaryNode currentNode = root;
    while (currentNode != null) {
      if(value < currentNode.getValue()) {
        currentNode = currentNode.getLeft();
      } else if(value > currentNode.getValue()) {
        currentNode = currentNode.getRight();
      } else {
        return currentNode;
      }
    }
    return null;
  }

  public void remove(int value) {
    if (root == null) {
      return;
    }

    MyBinaryNode nodeToRemove = root;
    MyBinaryNode parentNode = null;
    while (nodeToRemove.getValue() != value) { //Searching for the node to remove and it's parent
      parentNode = nodeToRemove;
      if (value < nodeToRemove.getValue()) {
        nodeToRemove = nodeToRemove.getLeft();
      } else if (value > nodeToRemove.getValue()) {
        nodeToRemove = nodeToRemove.getRight();
      }
    }

    MyBinaryNode replacementNode = null;
    if (nodeToRemove.getRight() != null) { //We have a right node
      replacementNode = nodeToRemove.getRight();
      if(replacementNode.getLeft() == null) { //We don't have a left node
        replacementNode.setLeft(nodeToRemove.getLeft());
      } else { //We have a have a left node, lets find the leftmost
        MyBinaryNode replacementParentNode = nodeToRemove;
        while (replacementNode.getLeft() != null) {
          replacementParentNode = replacementNode;
          replacementNode = replacementNode.getLeft();
        }
        replacementParentNode.setLeft(null);
        replacementNode.setLeft(nodeToRemove.getLeft());
        replacementNode.setRight(nodeToRemove.getRight());
      }
    } else if(nodeToRemove.getLeft() != null) {//We only have a left node
      replacementNode = nodeToRemove.getLeft();
    }

    if(parentNode == null) {
      root = replacementNode;
    } else if(parentNode.getLeft() == nodeToRemove) { //We are a left child
      parentNode.setLeft(replacementNode);
    } else { //We are a right child
      parentNode.setRight(replacementNode);
    }
  }

  int count = 0;
  public void printTree() {
    count = 0;
    printTree(root);
  }

  private void printTree(MyBinaryNode node) {
    System.out.print(node.getValue());
    System.out.println();
    count++;
    if(node.getLeft() != null) {
      System.out.print("\t".repeat(Math.max(0, count)) + "Left: ");
      printTree(node.getLeft());
    }
    if(node.getRight() != null) {
      System.out.print("\t".repeat(Math.max(0, count)) +"Right: ");
      printTree(node.getRight());
    }
    count--;
  }

  public static void main(String[] args) {
    MyBinarySearchTree tree = new MyBinarySearchTree();
    tree.insert(9);
    tree.insert(4);
    tree.insert(20);
    tree.insert(1);
    tree.insert(6);
    tree.insert(15);
    tree.insert(170);
    tree.printTree();
    tree.remove(20);
    tree.remove(4);
    tree.printTree();
    tree.insert(20);
    tree.insert(18);
    tree.insert(10);
    tree.printTree();
    tree.remove(170);
    tree.printTree();
  }
}
