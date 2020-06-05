package algorithms.recursion;

public class ReverseString {

  //Implement a function that reverses a string using iteration...and then recursion!

  public static String reverseStringRecursively(String string) { //O(n) - Where "n" is the length of the string
    if(string.length() == 0) {
      return "";
    }
    return reverseStringRecursively(string.substring(1)) + string.charAt(0);
  }

  public static String reverseStringIteratively(String string) { //O(n)
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < string.length(); i++) {
      result.append(string.charAt(string.length() - 1 - i));
    }
    return result.toString();
  }

  public static void main(String[] args) {
    System.out.println(reverseStringRecursively("123456"));
    System.out.println(reverseStringIteratively("123456"));
  }
}
