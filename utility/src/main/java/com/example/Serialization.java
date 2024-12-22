package com.example;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class Serialization {
  private static Gson gson = new Gson();

  public static String toJson(Object object) {
    return Serialization.gson.toJson(object);
  }

  public static <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {
    return Serialization.gson.fromJson(json, classOfT);
  }
}
