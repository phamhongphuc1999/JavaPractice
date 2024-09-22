/*https://leetcode.com/problems/longest-substring-without-repeating-characters/description/*/
package com.code;

import java.util.Arrays;

public class LongestSubstringWithoutRepeat {
  static boolean isValid(String s, int mid) {
    int[] count = new int[256];
    Arrays.fill(count, 0);
    int distinct = 0;
    int counter = 0;
    for (char s1 : s.toCharArray()) {
      if (count[s1] == 0)
        distinct++;
      count[s1]++;
      if (counter >= mid) {
        count[s.charAt(counter - mid)]--;
        if (count[s.charAt(counter - mid)] == 0)
          distinct--;
      }
      if (distinct == mid)
        return true;
      counter++;
    }
    return false;
  }

  static int lengthOfLongestSubstring(String s) {
    int len = s.length();
    if (len < 1)
      return 0;

    int[] count = new int[256];
    Arrays.fill(count, 0);
    int distinct = 0;
    for (char x : s.toCharArray()) {
      if (count[x] == 0)
        distinct++;
      count[x]++;
    }
    int low = 1, high = distinct;
    int result = 1;
    if (high == 1)
      return 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (isValid(s, mid)) {
        result = mid;
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return result;
  }
}
