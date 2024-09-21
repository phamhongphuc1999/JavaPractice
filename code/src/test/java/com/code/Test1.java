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

  private static Stream<Arguments> rdData() {
    return Stream.of(Arguments.of(new int[] { 1, 1, 2 }, 2),
        Arguments.of(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }, 5));
  }

  private static Stream<Arguments> reData() {
    return Stream.of(Arguments.of(new int[] { 3, 2, 2, 3 }, 3, 2),
        Arguments.of(new int[] { 0, 1, 2, 2, 3, 0, 4, 2 }, 2, 5));
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

  @ParameterizedTest
  @DisplayName("Remove Duplication")
  @MethodSource("rdData")
  void removeDuplication(int[] nums, int expectedLen) {
    int result = Simple.removeDuplicates(nums);
    assertEquals(result, expectedLen);
  }

  @ParameterizedTest
  @DisplayName("Remove Element")
  @MethodSource("reData")
  void removeElement(int[] nums, int val, int expectedLen) {
    int result = Simple.removeElement(nums, val);
    assertEquals(result, expectedLen);
  }

  @ParameterizedTest
  @DisplayName("Find the Index of the First Occurrence in a String")
  @CsvSource({ "sadbutsad, sad, 0", "leetcode, leeto, -1", "abcabcabc, cab, 2", "a, a, 0" })
  void findTheIndex(String haystack, String needle, int expectedIndex) {
    int result = Simple.strStr(haystack, needle);
    assertEquals(result, expectedIndex);
  }
}
