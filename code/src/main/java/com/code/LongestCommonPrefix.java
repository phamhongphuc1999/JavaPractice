package com.code;

import java.util.Stack;

public class LongestCommonPrefix {
  static String longestCommonPrefix(String[] strs) {
    String result = "";
    Integer size = strs.length;
    if (size == 0)
      return "";
    else if (size == 1)
      return strs[0];
    Integer counter = 0;
    try {
      while (true) {
        char _s = strs[0].charAt(counter);
        for (Integer i = 1; i < size; i++) {
          char _si = strs[i].charAt(counter);
          if (_s != _si)
            return result;
        }
        result += _s;
        counter++;
      }
    } catch (Exception e) {
      return result;
    }
  }

  static boolean isValidParentheses(String s) {
    Stack<Integer> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '{')
        stack.push(1);
      else if (c == '(')
        stack.push(2);
      else if (c == '[')
        stack.push(3);
      else {
        Integer size = stack.size();
        if (size == 0)
          return false;
        Integer check = c == '}' ? 1 : c == ')' ? 2 : 3;
        Integer n = stack.pop();
        if (check != n)
          return false;
      }
    }
    if (stack.size() > 0)
      return false;
    return true;
  }
}
