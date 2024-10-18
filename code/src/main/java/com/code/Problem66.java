package com.code;

import java.util.Arrays;

public class Problem66 {
  public static int[] plusOne(int[] digits) {
    int[] result = new int[digits.length + 1];
    int remainder = 1;
    for (int i = digits.length - 1; i >= 0; i--) {
      int raw = digits[i] + remainder;
      if (raw >= 10) {
        result[i + 1] = raw - 10;
        remainder = 1;
      } else {
        result[i + 1] = raw;
        remainder = 0;
      }
    }
    if (remainder == 1) {
      result[0] = 1;
      return result;
    } else
      return Arrays.copyOfRange(result, 1, result.length);
  }
}
