package com.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Problem2593 {
  static long findScore(int[] nums) {
    HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    int index = 0;
    for (int num : nums) {
      if (map.containsKey(num))
        map.get(num).add(index);
      else {
        PriorityQueue<Integer> temp = new PriorityQueue<>();
        temp.add(index);
        map.put(num, temp);
      }
      index++;
    }
    boolean[] marks = new boolean[nums.length];
    for (int i = 0; i < nums.length; i++)
      marks[i] = false;
    Arrays.sort(nums);
    long result = 0;
    for (int num : nums) {
      PriorityQueue<Integer> indices = map.get(num);
      if (indices.size() > 0) {
        int _index = indices.poll();
        while (marks[_index] && indices.size() > 0) {
          _index = indices.poll();
        }
        if (!marks[_index]) {
          result += num;
          marks[_index] = true;
          if (_index > 0)
            marks[_index - 1] = true;
          if (_index < nums.length - 1)
            marks[_index + 1] = true;
        }
      }
    }
    return result;
  }
}
