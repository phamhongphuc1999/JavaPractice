package com.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTracing {
  private static void backTracingNum(int[] candidates, int target, int beginIndex, List<Integer> path,
      List<List<Integer>> result,
      int currentTotal, int loop) {
    if (currentTotal == target) {
      result.add(new ArrayList<>(path.subList(0, loop)));
    } else if (currentTotal < target) {
      for (int i = beginIndex; i < candidates.length; i++) {
        if (currentTotal + candidates[i] <= target) {
          if (path.size() <= loop)
            path.add(candidates[i]);
          else
            path.set(loop, candidates[i]);
          backTracingNum(candidates, target, i, path, result, currentTotal + candidates[i], loop + 1);
        } else {
          break;
        }
      }
    }
  }

  // problem 39
  static List<List<Integer>> combinationSum(int[] candidates, int target) {
    int[] clone = candidates.clone();
    Arrays.sort(clone);
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    backTracingNum(clone, target, 0, path, result, 0, 0);
    return result;
  }

  private static void _permute(int[] nums, List<List<Integer>> result, List<Integer> path, boolean[] used) {
    if (path.size() == nums.length) {
      result.add(new ArrayList<>(path));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (!used[i]) {
        path.add(nums[i]);
        used[i] = true;
        _permute(nums, result, path, used);
        path.remove(path.size() - 1);
        used[i] = false;
      }
    }
  }

  // problem 46
  static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    boolean[] used = new boolean[nums.length];
    _permute(nums, result, new ArrayList<>(), used);
    return result;
  }
}
