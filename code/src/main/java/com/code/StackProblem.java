package com.code;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class StackProblem {
  static boolean isOperator(String s) {
    return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
  }

  // problem 150
  static int evalRPN(String[] tokens) {
    int len = tokens.length;
    Stack<Integer> numericStack = new Stack<>();
    Stack<String> operatorStack = new Stack<>();
    for (int i = 0; i < len; i++) {
      String token = tokens[i];
      if (isOperator(token)) {
        operatorStack.push(token);
      } else {
        numericStack.push(Integer.parseInt(token));
      }
      while (numericStack.size() >= 2 && !operatorStack.isEmpty()) {
        int num2 = numericStack.pop();
        int num1 = numericStack.pop();
        String operator = operatorStack.pop();
        if (operator.equals("+")) {
          numericStack.push(num1 + num2);
        } else if (operator.equals("-")) {
          numericStack.push(num1 - num2);
        } else if (operator.equals("*")) {
          numericStack.push(num1 * num2);
        } else if (operator.equals("/")) {
          numericStack.push(num1 / num2);
        }
      }
    }
    return numericStack.pop();
  }

  // problem 234
  boolean isPalindrome(ListNode head) {
    int size = 0;
    ListNode pointer = head;
    while (pointer != null) {
      size++;
      pointer = pointer.next;
    }
    Stack<Integer> stack = new Stack<>();
    pointer = head;
    for (int i = 0; i < size / 2; i++) {
      stack.push(pointer.val);
      pointer = pointer.next;
    }
    if (size % 2 == 1) {
      pointer = pointer.next;
    }
    for (int i = 0; i < size / 2; i++) {
      if (stack.pop() != pointer.val) {
        return false;
      }
      pointer = pointer.next;
    }
    return true;
  }

  // problem 503
  static int[] nextGreaterElements(int[] nums) {
    int[] result = new int[nums.length];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < result.length; i++) {
      result[i] = -1;
    }
    for (int i = 0; i < nums.length; i++) {
      while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
        result[stack.pop()] = nums[i];
      }
      stack.push(i);
    }
    for (int i = 0; i < nums.length; i++) {
      while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
        result[stack.pop()] = nums[i];
      }
      if (stack.empty())
        return result;
    }
    return result;
  }

  // problem 581
  static int findUnsortedSubarray(int[] nums) {
    Comparator<Integer> descOrder = (a, b) -> b - a;
    PriorityQueue<Integer> descQueue = new PriorityQueue<>(descOrder);

    Comparator<Integer> ascOrder = (a, b) -> a - b;
    PriorityQueue<Integer> ascQueue = new PriorityQueue<>(ascOrder);

    for (int i = 0; i < nums.length; i++) {
      descQueue.add(nums[i]);
      ascQueue.add(nums[i]);
    }
    int counter = 0;
    while (!ascQueue.isEmpty()) {
      if (ascQueue.poll() != nums[counter]) {
        break;
      }
      counter++;
    }
    int result = nums.length - counter;
    counter = nums.length - 1;
    while (!descQueue.isEmpty()) {
      if (descQueue.poll() != nums[counter]) {
        break;
      }
      counter--;
    }
    result = result - (nums.length - counter - 1);
    return result < 0 ? 0 : result;
  }
}
