package com.code;

import java.util.Arrays;

public class Problem2779 {
  static int binaryUpSearch(int[] nums, int target, int beginIndex, int endIndex) {
    int _begin = beginIndex;
    int _end = endIndex;
    while (_begin < _end) {
      int index = (_begin + _end) / 2;
      if (nums[index] <= target)
        _begin = index + 1;
      else if (nums[index] > target)
        _end = index - 1;
    }
    if (nums[_begin] > target)
      return _begin - 1;
    return _begin;
  }

  static int maximumBeauty(int[] nums, int k) {
    Arrays.sort(nums);
    int range = 2 * k;
    int len = nums.length;
    int[] save = new int[len];
    save[0] = binaryUpSearch(nums, nums[0] + range, 0, len - 1);
    int result = save[0] + 1;
    for (int i = 1; i < len; i++) {
      if (nums[i] == nums[i - 1]) {
        save[i] = save[i - 1];
      } else {
        int temp = binaryUpSearch(nums, nums[i] + range, save[i - 1], len - 1);
        save[i] = temp;
        int tempRange = temp - i + 1;
        if (tempRange > result)
          result = tempRange;
      }
    }
    return result;
  }
}
