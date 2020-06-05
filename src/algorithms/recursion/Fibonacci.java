package algorithms.recursion;

public class Fibonacci {
  // Given a number N return the index value of the Fibonacci sequence, where the sequence is:

// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ...
// the pattern of the sequence is that each value is the sum of the 2 previous values, that means that for N=5 → 2+3

//For example: fibonacciRecursive(6) should return 8

  public static int fibonacciRecursively(int n) { //O(2^n)
    if(n < 2) {
      return n;
    }
    return  fibonacciRecursively(n - 1) + fibonacciRecursively(n - 2);
  }

  public static int fibonacciIteratively(int n) { //O(n)
    if(n == 0) {
      return 0;
    }
    int result = 1;
    int lastNumber = 0;
    int temp;
    for (int i = 1; i < n; i++) {
      temp = result;
      result += lastNumber;
      lastNumber = temp;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(fibonacciIteratively(8));
    System.out.println(fibonacciRecursively(8));
  }
}
