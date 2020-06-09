package dynamic_programming;

import java.util.HashMap;

public class DynamicFibonacci {

  private static final HashMap<Integer, Integer> cache = new HashMap<>();
  public static int fibonacciMaster(int n) {
    if(cache.containsKey(n)) {
      return cache.get(n);
    }
    if(n < 2){
      return n;
    }
    cache.put(n, fibonacciMaster(n - 1) + fibonacciMaster(n - 2));
    return cache.get(n);
  }

  public static void main(String[] args) {
    System.out.println(fibonacciMaster(1000));
  }
}
