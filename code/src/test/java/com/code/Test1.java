package com.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class Test1 {
  private static Stream<Arguments> lcpData() {
    return Stream.of(
        Arguments.of(new String[] { "flower", "flow", "flight" }, "fl"),
        Arguments.of(new String[] { "dog", "racecar", "car" }, ""));
  }

  @ParameterizedTest
  @DisplayName("Smallest window sliding")
  @CsvSource({ "ADOBECODEBANC, ABC, BANC", "AAAAA, A, A", "B, BB, ''" })
  void windowSliding(String source, String target, String expectedResult) {
    String output = WindowSliding.minWindow(source, target);
    assertEquals(expectedResult, output);
  }

  @ParameterizedTest
  @DisplayName("Longest common prefix")
  @MethodSource("lcpData")
  void longestCommonPrefix(String[] strs, String expectedResult) {
    String result = LongestCommonPrefix.longestCommonPrefix(strs);
    assertEquals(expectedResult, result);
  }

  @ParameterizedTest
  @DisplayName("Valid parentheses")
  @CsvSource({ "(), true", "([{)}], false", "()[]{}, true", "(, false" })
  void isValidParentheses(String s, boolean expectedResult) {
    boolean result = LongestCommonPrefix.isValidParentheses(s);
    assertEquals(expectedResult, result);
  }
}
