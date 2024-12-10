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

  static String runLengthEncoding(String s) {
    String result = "";
    int counter = 0;
    char c = s.charAt(0);
    for (int i = 0; i < s.length(); i++) {
      char test = s.charAt(i);
      if (c == test)
        counter++;
      else {
        result += String.format("%s%s", counter, c);
        counter = 1;
      }
      c = test;
    }
    result += String.format("%s%s", counter, c);
    return result;
  }

  // https://leetcode.com/problems/count-and-say/description/
  static String countAndSay(int n) {
    if (n == 1)
      return "1";
    String[] arr = new String[n];
    arr[0] = "1";
    for (int i = 1; i < n; i++) {
      arr[i] = runLengthEncoding(arr[i - 1]);
    }
    return arr[n - 1];
  }
}
