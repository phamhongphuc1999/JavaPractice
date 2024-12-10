package com.code;

import java.util.HashMap;
import java.util.Map;

public class Problem2981 {
  static void incrementMap(Map<String, Integer> map, String key) {
    if (map.containsKey(key)) {
      int currentValue = map.get(key);
      map.replace(key, currentValue + 1);
    } else
      map.put(key, 1);
  }

  static void incrementMap(Map<String, Integer> map, String key, Integer value) {
    if (map.containsKey(key)) {
      int currentValue = map.get(key);
      map.replace(key, currentValue + value);
    } else
      map.put(key, value);
  }

  static int maximumLength(String s) {
    int len = s.length();
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < len; i++) {
      String c = s.substring(i, i + 1);
      incrementMap(map, c);
      int j = i - 1;
      while (j >= 0) {
        if (s.substring(j, j + 1).equals(c))
          incrementMap(map, s.substring(j, i + 1));
        else
          j = -1;
        j--;
      }
    }
    int maxLen = -1;
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      int _len = entry.getKey().length();
      int _counter = entry.getValue();
      if (_counter >= 3 && _len > maxLen)
        maxLen = _len;
    }
    return maxLen;
  }

  static int maximumLength2982(String s) {
    int len = s.length();
    Map<String, Integer> map = new HashMap<>();
    String subString = "";
    for (int i = 0; i < len; i++) {
      String c = s.substring(i, i + 1);
      if (subString.length() == 0)
        subString = c;
      else if (subString.substring(0, 1).equals(c))
        subString += c;
      else {
        incrementMap(map, String.format("%s-%s", subString.length(), subString.charAt(0)));
        subString = c;
      }
    }
    incrementMap(map, String.format("%s-%s", subString.length(), subString.charAt(0)));
    Map<String, Integer> result = new HashMap<>();
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      String _key = entry.getKey();
      Integer _value = entry.getValue();
      incrementMap(result, _key, _value);
      String[] data = _key.split("-");
      int _len = Integer.parseInt(data[0]);
      for (int i = _len - 1; i >= 1; i--) {
        incrementMap(result, String.format("%s-%s", i, data[1]), (_len - i + 1) * _value);
      }
    }
    int maxLen = -1;
    for (Map.Entry<String, Integer> entry : result.entrySet()) {
      String _key = entry.getKey();
      String[] data = _key.split("-");
      int _len = Integer.parseInt(data[0]);
      int _counter = entry.getValue();
      if (_counter >= 3 && _len > maxLen)
        maxLen = _len;
    }
    return maxLen;
  }

  static int min(int a, int b, int c) {
    return a < Math.min(b, c) ? a : Math.min(b, c);
  }

  static int maximumLengthFast(String s) {
    int substringLength = 0, ans = -1;
    char previousCharacter = '\0';
    int[][] substringLengths = new int[26][3];

    for (int charIdx = 0; charIdx < 26; charIdx++) {
      for (int lenIdx = 0; lenIdx < 3; lenIdx++) {
        substringLengths[charIdx][lenIdx] = -1;
      }
    }

    for (char character : s.toCharArray()) {
      if (character == previousCharacter) {
        substringLength++;
      } else {
        substringLength = 1;
        previousCharacter = character;
      }

      int index = character - 'a';
      int minLength = min(
          substringLengths[index][0],
          substringLengths[index][1],
          substringLengths[index][2]);
      if (substringLength > minLength) {
        if (substringLengths[index][0] == minLength) {
          substringLengths[index][0] = substringLength;
        } else if (substringLengths[index][1] == minLength) {
          substringLengths[index][1] = substringLength;
        } else {
          substringLengths[index][2] = substringLength;
        }
      }
    }

    for (int charIdx = 0; charIdx < 26; charIdx++) {
      ans = Math.max(
          ans,
          min(
              substringLengths[charIdx][0],
              substringLengths[charIdx][1],
              substringLengths[charIdx][2]));
    }
    return ans;
  }
}
