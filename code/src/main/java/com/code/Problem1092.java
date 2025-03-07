package com.code;

import java.util.HashMap;
import java.util.Map;

public class Problem1092 {
  public static String worstSolution(String str1, String str2) {
    if (str1.length() == 0)
      return str2;
    else if (str2.length() == 0)
      return str1;
    else {
      if (str1.charAt(0) == str2.charAt(0))
        return str1.charAt(0) + worstSolution(str1.substring(1), str2.substring(1));
      else {
        String choice1 = str1.charAt(0) + worstSolution(str1.substring(1), str2);
        String choice2 = str2.charAt(0) + worstSolution(str2.substring(1), str1);
        return choice1.length() > choice2.length() ? choice2 : choice1;
      }
    }
  }

  private static String helper(String str1, String str2, Map<String, String> memo) {
    String key = str1 + " " + str2;
    if (memo.containsKey(key))
      return memo.get(key);
    if (str1.length() == 0 && str2.length() == 0)
      return "";
    if (str1.length() == 0)
      return str2;
    else if (str2.length() == 0)
      return str1;
    if (str1.charAt(0) == str2.charAt(0)) {
      String result = str1.charAt(0) + helper(str1.substring(0), str2.substring(0), memo);
      memo.put(key, result);
      return result;
    } else {
      String choice1 = str1.charAt(0) + helper(str1.substring(0), str2, memo);
      String choice2 = str2.charAt(0) + helper(str2.substring(0), str1, memo);
      String result = choice1.length() > choice2.length() ? choice2 : choice1;
      memo.put(key, result);
      return result;
    }
  }

  public static String worstMemorySolution(String str1, String str2) {
    Map<String, String> memo = new HashMap<>();
    return helper(str1, str2, memo);
  }
}
