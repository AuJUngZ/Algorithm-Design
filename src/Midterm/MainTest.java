package Midterm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {
  //    @Test
  //    void test() {
  //        int[] maxValues = new int[100];
  //        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39,
  // 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63,
  // 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87,
  // 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100};
  //        int rodLength = 80;
  //        assertEquals(13, Midterm.RodCuttingProblem.findMaxValue(rodLength, prices, maxValues));
  //        assertEquals(150, Midterm.RodCuttingProblem.buttomUp(rodLength, prices));
  //        assertEquals(90, Midterm.RodCuttingProblem.findMax2(rodLength, prices));
  //    }
  @Test
  void test() {
    int n = 45;
    long[] x = new long[n + 1];
    //        assertEquals(1134903170, Midterm.Fibonacci.Fib(n));
    assertEquals(1134903170, Fibonacci.topDown(n, x));
    //        assertEquals(1, Midterm.Fibonacci.buttomUp(5));
  }
}
