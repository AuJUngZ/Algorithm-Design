package Midterm;

public class Primefactorization {
  public int number;

  public Primefactorization(int number) {
    this.number = number;
  }

  // recursive method to find prime factors
  public static int[] getFactors(int[] factors, int number, int index) {
    if (number == 1) {
      return factors;
    } else {
      int factor = 2;
      while (number % factor != 0) {
        factor++;
      }
      factors[index] = factor;
      index++;
      number = number / factor;
      return getFactors(factors, number, index);
    }
  }
}
