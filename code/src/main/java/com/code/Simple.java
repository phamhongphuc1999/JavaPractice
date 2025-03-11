package com.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Simple {
  static int removeDuplicates(int[] numList) {
    if (numList.length == 0)
      return 0;
    int result = 0;
    int currentValue = numList[0];
    for (int n : numList) {
      if (currentValue != n) {
        result += 1;
        currentValue = n;
        numList[result] = currentValue;
      }
    }
    return result + 1;
  }

  static int removeElement(int[] numList, int val) {
    if (numList.length == 0)
      return 0;
    int result = -1;
    for (int n : numList) {
      if (n != val) {
        result += 1;
        numList[result] = n;
      }
    }
    return result + 1;
  }

  static int strStr(String haystack, String needle) {
    int hLen = haystack.length();
    int nLen = needle.length();
    for (int i = 0; i <= hLen - nLen; i++) {
      boolean isCheck = true;
      for (int j = 0; j < nLen; j++) {
        if (haystack.charAt(i + j) != needle.charAt(j)) {
          isCheck = false;
          break;
        }
      }
      if (isCheck)
        return i;
    }
    return -1;
  }

  static String addBinary(String a, String b) {
    String result = "";
    int aLen = a.length();
    int bLen = b.length();
    int aCounter = aLen - 1;
    int bCounter = bLen - 1;
    char remaining = '0';
    while (aCounter >= 0 && bCounter >= 0) {
      int total = a.charAt(aCounter) + b.charAt(bCounter) + remaining;
      if (total == 144) {
        result = '0' + result;
        remaining = '0';
      } else if (total == 145) {
        result = '1' + result;
        remaining = '0';
      } else if (total == 146) {
        result = '0' + result;
        remaining = '1';
      } else {
        result = '1' + result;
        remaining = '1';
      }
      aCounter--;
      bCounter--;
    }
    while (aCounter >= 0) {
      int total = remaining + a.charAt(aCounter);
      if (total == 96) {
        result = '0' + result;
        remaining = '0';
      } else if (total == 97) {
        result = '1' + result;
        remaining = '0';
      } else {
        result = '0' + result;
        remaining = '1';
      }
      aCounter--;
    }
    while (bCounter >= 0) {
      int total = remaining + b.charAt(bCounter);
      if (total == 96) {
        result = '0' + result;
        remaining = '0';
      } else if (total == 97) {
        result = '1' + result;
        remaining = '0';
      } else {
        result = '0' + result;
        remaining = '1';
      }
      bCounter--;
    }
    if (remaining == '1')
      result = '1' + result;
    return result;
  }

  static int mySqrt(int x) {
    if (x == 0)
      return 0;
    if (x <= 3)
      return 1;
    int result = 2;
    while (result <= x / 2) {
      int p = x / result;
      if (p == result)
        return p;
      else {
        if (p + 1 == result)
          return p;
        else if (p == result + 1)
          return result;
        result = (result + p) / 2;
      }
    }
    return result;
  }

  // https://leetcode.com/problems/climbing-stairs/
  static int climbStairs(int n) {
    if (n == 1)
      return 1;
    else if (n == 2)
      return 2;
    int[] arr = new int[45];
    arr[0] = 1;
    arr[1] = 2;
    for (int i = 2; i <= n - 1; i++) {
      arr[i] = arr[i - 1] + arr[i - 2];
    }
    return arr[n - 1];
  }

  // https://leetcode.com/problems/n-th-tribonacci-number/description/
  static int tribonacci(int n) {
    if (n == 0)
      return 0;
    else if (n <= 2)
      return 1;
    int[] arr = new int[37];
    arr[0] = 0;
    arr[1] = arr[2] = 1;
    for (int i = 3; i <= n; i++) {
      arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
    }
    return arr[n];
  }

  static ListNode deleteDuplicates(ListNode head) {
    if (head == null)
      return null;
    ListNode result = new ListNode(head.val);
    ListNode resultTail = result;
    ListNode pointer = head.next;
    while (pointer != null) {
      if (pointer.val != resultTail.val) {
        ListNode temp = new ListNode(pointer.val);
        resultTail.next = temp;
        resultTail = temp;
      }
      pointer = pointer.next;
    }
    return result;
  }

  // problem 2558
  static long pickGifts(int[] gifts, int k) {
    Comparator<Integer> descendingOrder = (a, b) -> b - a;
    PriorityQueue<Integer> heap = new PriorityQueue<>(descendingOrder);
    for (int item : gifts) {
      heap.add(item);
    }
    for (int i = 0; i < k; i++) {
      int item = heap.poll();
      heap.add((int) Math.floor(Math.sqrt(item)));
    }
    long result = 0;
    while (heap.size() > 0) {
      result += heap.poll();
    }
    return result;
  }

  // problem 88
  void merge(int[] nums1, int m, int[] nums2, int n) {
    int[] temp1 = new int[m];
    for (int i = 0; i < m; i++)
      temp1[i] = nums1[i];
    int m1 = 0;
    int n1 = 0;
    int counter = 0;
    while (m1 < m && n1 < n) {
      if (temp1[m1] < nums2[n1])
        nums1[counter++] = temp1[m1++];
      else
        nums1[counter++] = nums2[n1++];
    }
    while (m1 < m) {
      nums1[counter++] = temp1[m1++];
    }
    while (n1 < n) {
      nums1[counter++] = nums2[n1++];
    }
  }

  // problem 118
  static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(Arrays.asList(1));
    if (numRows == 1)
      return result;
    result.add(Arrays.asList(1, 1));
    if (numRows == 2)
      return result;
    for (int i = 3; i <= numRows; i++) {
      List<Integer> preArr = result.get(i - 2);
      List<Integer> temp = new ArrayList<>();
      temp.add(1);
      for (int j = 1; j <= i - 2; j++)
        temp.add(preArr.get(j - 1) + preArr.get(j));
      temp.add(1);
      result.add(temp);
    }
    return result;
  }

  // problem 119
  public static List<Integer> getRow(int rowIndex) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(Arrays.asList(1));
    if (rowIndex == 0)
      return result.get(0);
    result.add(Arrays.asList(1, 1));
    if (rowIndex == 1)
      return result.get(1);
    for (int i = 2; i <= rowIndex; i++) {
      List<Integer> preArr = result.get(i - 1);
      List<Integer> temp = new ArrayList<>();
      temp.add(1);
      for (int j = 1; j <= i - 1; j++)
        temp.add(preArr.get(j - 1) + preArr.get(j));
      temp.add(1);
      result.add(temp);
    }
    return result.get(rowIndex);
  }

  // problem 1475
  int[] finalPrices(int[] prices) {
    int[] result = prices.clone();
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < prices.length; i++) {
      while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
        result[stack.pop()] -= prices[i];
      }
      stack.add(i);
    }
    return result;
  }

  // problem 168
  static String convertToTitle(int columnNumber) {
    String result = "";
    while (columnNumber > 0) {
      int remaining = columnNumber % 26;
      if (remaining == 0) {
        remaining = 26;
        columnNumber -= 26;
      }
      result = (char) ('A' + (remaining - 1)) + result;
      columnNumber = columnNumber / 26;
    }
    return result;
  }

  // problem 1346
  static boolean checkIfExist(int[] arr) {
    HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
    int counterZero = 0;
    for (int i : arr) {
      if (i == 0) {
        counterZero++;
        if (counterZero > 1)
          return true;
      } else {
        if (cache.containsKey(i)) {
          if (cache.get(i) == 2)
            return true;
        } else {
          cache.put(i, 1);
          int doubleValue = i * 2;
          if (cache.containsKey(doubleValue))
            return true;
          else
            cache.put(doubleValue, 2);
        }
      }
    }
    return false;
  }

  // problem 496
  static int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int[] result = new int[nums1.length];
    for (int i = 0; i < result.length; i++)
      result[i] = -1;
    HashMap<Integer, Integer> cache = new HashMap<>();
    int counter = 0;
    for (int i : nums1) {
      cache.put(i, counter);
      counter++;
    }
    Stack<Integer> stack = new Stack<>();
    for (int i : nums2) {
      while (!stack.isEmpty() && stack.peek() < i) {
        result[cache.get(stack.pop())] = i;
      }
      if (cache.containsKey(i))
        stack.add(i);
    }
    return result;
  }
}
