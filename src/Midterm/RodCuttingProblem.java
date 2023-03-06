package Midterm;

public class RodCuttingProblem {
  public static int findMaxValue(int rodLength, int[] prices, int[] maxValues, int[] cuts) {
    if (maxValues[rodLength] != 0) {
      return maxValues[rodLength];
    } else {
      if (rodLength == 0) {
        return 0;
      } else {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 1; i <= rodLength; i++) {
          int currentValue = prices[i - 1] + findMaxValue(rodLength - i, prices, maxValues, cuts);
          if (currentValue > maxValue) {
            maxValue = currentValue;
            cuts[rodLength] = i;
          }
        }
        maxValues[rodLength] = maxValue;
      }
    }
    return maxValues[rodLength];
  }

  public static int buttomUp(int rodLength, int[] prices) {
    int[] maxValues = new int[rodLength + 1];
    maxValues[0] = 0;
    for (int i = 1; i <= rodLength; i++) {
      int maxValue = Integer.MIN_VALUE;
      for (int j = 1; j <= i; j++) {
        maxValue = Math.max(maxValue, prices[j - 1] + maxValues[i - j]);
      }
      maxValues[i] = maxValue;
    }
    return maxValues[rodLength];
  }

  public static int findMax2(int rodLength, int[] prices) {
    if (rodLength == 0) {
      return 0;
    } else {
      int maxValue = Integer.MIN_VALUE;
      for (int i = 1; i <= rodLength; i++) {
        maxValue = Math.max(maxValue, prices[i - 1] + findMax2(rodLength - i, prices));
      }
      return maxValue;
    }
  }

  public static int aujung(int rodLength, int[] prices, int[] maxValues, int[] cuts) {
    if (rodLength == 0) {
      return 0;
    } else {
      for (int i = rodLength; i >= 1; i--) {
        int max =
            Math.max(
                prices[i - 1] + aujung(rodLength - i, prices, maxValues, cuts),
                maxValues[rodLength]);
        if (max > maxValues[rodLength]) {
          maxValues[rodLength] = max;
          cuts[rodLength] = i;
        }
      }
    }
    return maxValues[rodLength];
  }
}
