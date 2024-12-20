package com.code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem769 {
  static int maxChunksToSorted(int[] arr) {
    Map<Integer, Integer> indices = new HashMap<>();
    int[] temp = arr.clone();
    Arrays.sort(temp);
    for (int i = 0; i < temp.length; i++) {
      indices.put(temp[i], i);
    }
    Comparator<Integer> descendingOrder = (a, b) -> b - a;
    PriorityQueue<Integer> queue = new PriorityQueue<>(descendingOrder);
    int result = 0;
    for (int i = 0; i < arr.length; i++) {
      queue.add(arr[i]);
      int largestValue = queue.peek();
      int arrangedIndex = indices.get(largestValue);
      if (arrangedIndex == i)
        result++;
    }
    return result;
  }
}
