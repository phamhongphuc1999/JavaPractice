package com.code;

import com.code.utilities.TreeNode;

public class Problem2415 {
  static void resolve(TreeNode leftRoot, TreeNode rightRoot, int level) {
    if (leftRoot != null && rightRoot != null) {
      if (level % 2 == 1) {
        int temp = leftRoot.val;
        leftRoot.val = rightRoot.val;
        rightRoot.val = temp;
      }
      resolve(leftRoot.left, rightRoot.right, level + 1);
      resolve(leftRoot.right, rightRoot.left, level + 1);
    }
  }

  static TreeNode reverseOddLevels(TreeNode root) {
    if (root != null)
      resolve(root.left, root.right, 1);
    return root;
  }
}
