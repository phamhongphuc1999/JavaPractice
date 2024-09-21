package com.code;

public class Simple {
  static int removeDuplicates(int[] nums) {
    if (nums.length == 0)
      return 0;
    int result = 0;
    int currentValue = nums[0];
    for (int n : nums) {
      if (currentValue != n) {
        result += 1;
        currentValue = n;
        nums[result] = currentValue;
      }
    }
    return result + 1;
  }

  static int removeElement(int[] nums, int val) {
    if (nums.length == 0)
      return 0;
    int result = -1;
    for (int n : nums) {
      if (n != val) {
        result += 1;
        nums[result] = n;
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
}
