package com.code;

import java.util.Stack;

import com.code.utilities.TreeNode;

public class DeepFirstSearch {
  static boolean isSameTree(TreeNode p, TreeNode q) {
    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();
    stack1.push(p);
    stack2.push(q);
    while (!stack1.empty() && !stack2.isEmpty()) {
      TreeNode _p = stack1.pop();
      TreeNode _q = stack2.pop();
      if (_p == null && _q != null)
        return false;
      if (_p != null && _q == null)
        return false;
      if (_p != null && _q != null) {
        if (_p.val != _q.val)
          return false;
        stack1.push(_p.left);
        stack1.push(_p.right);
        stack2.push(_q.left);
        stack2.push(_q.right);
      }
    }
    return true;
  }
}
