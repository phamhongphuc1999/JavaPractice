package com.kafka;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JsonExtraction {
  public static String extractId(String json) {
    JsonElement jsonObj = JsonParser.parseString(json).getAsJsonObject().get("meta");
    JsonElement _id = jsonObj.getAsJsonObject().get("id");
    return _id.getAsString();
  }
}
