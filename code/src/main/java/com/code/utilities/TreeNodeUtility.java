package com.code.utilities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNodeUtility {
  public static void printArray(Integer[] arr) {
    for (Integer integer : arr) {
      System.err.print(integer + ", ");
    }
    System.err.println();
  }

  public static void printArray(List<Integer> arr) {
    for (Integer integer : arr) {
      System.err.print(integer + ", ");
    }
    System.err.println();
  }

  public static TreeNode convertArrayToTree(Integer[] arr) {
    if (arr.length == 0)
      return null;
    TreeNode tree = new TreeNode(arr[0]);
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(tree);
    int counter = 1;
    int _len = arr.length;
    while (counter < _len) {
      Integer leftValue = arr[counter];
      TreeNode root = queue.poll();
      if (leftValue != null) {
        TreeNode left = new TreeNode(leftValue);
        root.left = left;
        queue.add(left);
      }
      counter++;
      if (counter < _len) {
        Integer rightValue = arr[counter];
        if (rightValue != null) {
          TreeNode right = new TreeNode(rightValue);
          root.right = right;
          queue.add(right);
        }
      }
      counter++;
    }
    return tree;
  }

  public static List<Integer> convertTreeToArray(TreeNode tree) {
    Queue<TreeNode> stack = new LinkedList<>();
    stack.add(tree);
    List<Integer> result = new ArrayList<>();
    while (!stack.isEmpty()) {
      TreeNode node = stack.poll();
      if (node != null) {
        result.add(node.val);
        stack.add(node.left);
        stack.add(node.right);
      } else
        result.add(null);
    }
    int _len = result.size();
    while (result.get(_len - 1) == null) {
      result.remove(_len - 1);
      _len--;
    }
    return result;
  }
}
