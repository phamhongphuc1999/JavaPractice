package com.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.code.utilities.TrackPathTreeDeepNode;
import com.code.utilities.TreeDeepNode;
import com.code.utilities.TreeNode;

// To implement deep first search or breadth first search, you can use Stack or Queue.

public class DeepFirstSearch {
  // problem 100
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

  // problem 101
  static boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> leftQueue = new LinkedList<>();
    Queue<TreeNode> rightQueue = new LinkedList<>();
    if (root == null)
      return true;
    leftQueue.add(root.left);
    rightQueue.add(root.right);
    while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
      TreeNode leftNode = leftQueue.poll();
      TreeNode rightNode = rightQueue.poll();
      if (leftNode != null && rightNode == null)
        return false;
      if (leftNode == null && rightNode != null)
        return false;
      if (leftNode != null && rightNode != null) {
        if (leftNode.val != rightNode.val)
          return false;
        leftQueue.add(leftNode.left);
        leftQueue.add(rightNode.left);
        rightQueue.add(rightNode.right);
        rightQueue.add(leftNode.right);
      }
    }
    if (!leftQueue.isEmpty() || !rightQueue.isEmpty())
      return false;
    return true;
  }

  static public int maxDepth(TreeNode root) {
    Stack<TreeDeepNode> stack = new Stack<>();
    if (root == null)
      return 0;
    stack.push(new TreeDeepNode(root, 1));
    int maxLevel = 1;
    while (!stack.isEmpty()) {
      TreeDeepNode node = stack.pop();
      if (node.level > maxLevel)
        maxLevel = node.level;
      if (node.tree.left != null)
        stack.push(new TreeDeepNode(node.tree.left, node.level + 1));
      if (node.tree.right != null)
        stack.push(new TreeDeepNode(node.tree.right, node.level + 1));
    }
    return maxLevel;
  }

  static int minDepth(TreeNode root) {
    if (root == null)
      return 0;
    Queue<TreeDeepNode> queue = new LinkedList<>();
    queue.add(new TreeDeepNode(root, 1));
    while (!queue.isEmpty()) {
      TreeDeepNode node = queue.poll();
      TreeNode tree = node.tree;
      if (tree.left == null && tree.right == null) {
        return node.level;
      }
      if (tree.left != null)
        queue.add(new TreeDeepNode(tree.left, node.level + 1));
      if (tree.right != null)
        queue.add(new TreeDeepNode(tree.right, node.level + 1));
    }
    return 0;
  }

  static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    Stack<TrackPathTreeDeepNode> stack = new Stack<>();
    List<List<Integer>> result = new ArrayList<>();
    if (root == null)
      return result;
    List<Integer> rootList = new ArrayList<>();
    rootList.add(root.val);
    stack.push(new TrackPathTreeDeepNode(root, rootList, root.val));
    while (!stack.isEmpty()) {
      TrackPathTreeDeepNode data = stack.pop();
      TreeNode node = data.tree;
      if (node.left == null && node.right == null && data.total == targetSum)
        result.add(data.list);
      if (node.left != null) {
        int val = node.left.val;
        List<Integer> left = new ArrayList<>(data.list);
        left.add(val);
        stack.push(new TrackPathTreeDeepNode(node.left, left, data.total + val));
      }
      if (node.right != null) {
        int val = node.right.val;
        List<Integer> right = new ArrayList<>(data.list);
        right.add(val);
        stack.push(new TrackPathTreeDeepNode(node.right, right, data.total + val));
      }
    }
    return result;
  }

  static void flatten(TreeNode root) {
    if (root == null)
      return;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    List<TreeNode> list = new ArrayList<>();
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      list.add(node);
      if (node.right != null)
        stack.push(node.right);
      if (node.left != null)
        stack.push(node.left);
    }
    root = list.get(0);
    TreeNode pointer = root;
    for (int i = 1; i < list.size(); i++) {
      pointer.left = null;
      pointer.right = list.get(i);
      pointer = list.get(i);
    }
  }
}
