package utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class LoadInput {

  public static String load(String path) throws IOException {
    try (var in = LoadInput.class.getResourceAsStream(path)) {
      if (in == null) throw new IOException();
      return new String(in.readAllBytes(), StandardCharsets.UTF_8);
    }
  }

  public static List<String> loadInput(String path) throws IOException {
    return Arrays.asList(load(path).split("\n"));
  }
}
