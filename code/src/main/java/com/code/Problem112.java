package com.code;

import com.code.utilities.TreeNode;

public class Problem112 {
  static boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null)
      return false;
    boolean isLeaf = root.left == null && root.right == null;
    int newRemaining = targetSum - root.val;
    if (isLeaf) {
      if (newRemaining == 0)
        return true;
      else
        return false;
    } else {
      TreeNode left = root.left;
      boolean isLeft = left != null;
      if (isLeft)
        isLeft = hasPathSum(left, newRemaining);
      if (isLeft)
        return true;
      else {
        TreeNode right = root.right;
        boolean isRight = right != null;
        if (isRight)
          isRight = hasPathSum(right, newRemaining);
        return isRight;
      }
    }
  }
}
