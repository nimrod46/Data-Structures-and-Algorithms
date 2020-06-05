package algorithms.recursion;

public class Factorial {
  // Write two functions that finds the factorial of any number.
  // One should use recursive, the other should just use a for loop

  public static long findFactorialRecursively(long number) { // O(n)
    if (number == 1) {
      return 1;
    }
    return number * findFactorialRecursively(number - 1);
  }

  public static long findFactorialIteratively(long number) { // O(n)
    long result = 1;
    for (long i = number; i > 0; i--) {
      result *= i;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(findFactorialRecursively(10000));
    System.out.println(findFactorialIteratively(1000000));
  }
}
