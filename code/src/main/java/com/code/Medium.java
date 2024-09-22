package com.code;

import java.util.Arrays;

public class Medium {
  /* https://leetcode.com/problems/zigzag-conversion/ */
  static String convert(String s, int numRows) {
    if (numRows == 1)
      return s;
    String[] temp = new String[numRows];
    Arrays.fill(temp, "");
    int remain = 0;
    boolean up = true;
    for (char s1 : s.toCharArray()) {
      temp[remain] += s1;
      if (up)
        remain++;
      else
        remain--;
      if (remain == 0 || remain == numRows - 1)
        up = !up;
    }
    return String.join("", temp);
  }
}
