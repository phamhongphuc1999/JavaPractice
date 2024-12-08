package com.code;

public class Simple {
  static int removeDuplicates(int[] numList) {
    if (numList.length == 0)
      return 0;
    int result = 0;
    int currentValue = numList[0];
    for (int n : numList) {
      if (currentValue != n) {
        result += 1;
        currentValue = n;
        numList[result] = currentValue;
      }
    }
    return result + 1;
  }

  static int removeElement(int[] numList, int val) {
    if (numList.length == 0)
      return 0;
    int result = -1;
    for (int n : numList) {
      if (n != val) {
        result += 1;
        numList[result] = n;
      }
    }
    return result + 1;
  }

  static int strStr(String haystack, String needle) {
    int hLen = haystack.length();
    int nLen = needle.length();
    for (int i = 0; i <= hLen - nLen; i++) {
      boolean isCheck = true;
      for (int j = 0; j < nLen; j++) {
        if (haystack.charAt(i + j) != needle.charAt(j)) {
          isCheck = false;
          break;
        }
      }
      if (isCheck)
        return i;
    }
    return -1;
  }

  static String addBinary(String a, String b) {
    String result = "";
    int aLen = a.length();
    int bLen = b.length();
    int aCounter = aLen - 1;
    int bCounter = bLen - 1;
    char remaining = '0';
    while (aCounter >= 0 && bCounter >= 0) {
      int total = a.charAt(aCounter) + b.charAt(bCounter) + remaining;
      if (total == 144) {
        result = '0' + result;
        remaining = '0';
      } else if (total == 145) {
        result = '1' + result;
        remaining = '0';
      } else if (total == 146) {
        result = '0' + result;
        remaining = '1';
      } else {
        result = '1' + result;
        remaining = '1';
      }
      aCounter--;
      bCounter--;
    }
    while (aCounter >= 0) {
      int total = remaining + a.charAt(aCounter);
      if (total == 96) {
        result = '0' + result;
        remaining = '0';
      } else if (total == 97) {
        result = '1' + result;
        remaining = '0';
      } else {
        result = '0' + result;
        remaining = '1';
      }
      aCounter--;
    }
    while (bCounter >= 0) {
      int total = remaining + b.charAt(bCounter);
      if (total == 96) {
        result = '0' + result;
        remaining = '0';
      } else if (total == 97) {
        result = '1' + result;
        remaining = '0';
      } else {
        result = '0' + result;
        remaining = '1';
      }
      bCounter--;
    }
    if (remaining == '1')
      result = '1' + result;
    return result;
  }

  static int mySqrt(int x) {
    if (x == 0)
      return 0;
    if (x <= 3)
      return 1;
    int result = 2;
    while (result <= x / 2) {
      int p = x / result;
      if (p == result)
        return p;
      else {
        if (p + 1 == result)
          return p;
        else if (p == result + 1)
          return result;
        result = (result + p) / 2;
      }
    }
    return result;
  }

  // https://leetcode.com/problems/climbing-stairs/
  static int climbStairs(int n) {
    if (n == 1)
      return 1;
    else if (n == 2)
      return 2;
    int[] arr = new int[45];
    arr[0] = 1;
    arr[1] = 2;
    for (int i = 2; i <= n - 1; i++) {
      arr[i] = arr[i - 1] + arr[i - 2];
    }
    return arr[n - 1];
  }

  // https://leetcode.com/problems/n-th-tribonacci-number/description/
  static int tribonacci(int n) {
    if (n == 0)
      return 0;
    else if (n <= 2)
      return 1;
    int[] arr = new int[37];
    arr[0] = 0;
    arr[1] = arr[2] = 1;
    for (int i = 3; i <= n; i++) {
      arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
    }
    return arr[n];
  }
}
