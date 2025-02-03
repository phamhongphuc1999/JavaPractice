package com.word.word.utils;

import java.nio.charset.StandardCharsets;

public class EncodingFixer {
  public static String fixEncoding(String input) {
    return new String(input.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
  }

  public static String fixText(String text) {
    return new String(text.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
  }
}
