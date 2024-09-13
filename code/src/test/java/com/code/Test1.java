package com.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Test1 {
  @ParameterizedTest
  @DisplayName("Smallest window sliding")
  @CsvSource({ "ADOBECODEBANC, ABC, BANC", "AAAAA, A, A", "B, BB, ''" })
  void WindowSliding(String source, String target, String expectedResult) {
    String output = WindowSliding.minWindow(source, target);
    assertEquals(expectedResult, output);
  }
}
