package com.tombun.day11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day11 {
  public static long partOne(List<String> input) {
    List<String> stones = new java.util.ArrayList<>(Arrays.stream(input.getFirst().split(" ")).toList());

    long res = 0;
    for (String stone : stones) res += traverse(stone, 25, new HashMap<>());
    return res;
  }

  public static long partTwo(List<String> input) {
    List<String> stones = new java.util.ArrayList<>(Arrays.stream(input.getFirst().split(" ")).toList());

    long res = 0;
    for (String stone : stones) res += traverse(stone, 75, new HashMap<>());
    return res;
  }

  private static long traverse(String stone, int counter, Map<String, Long> cache) {
    if (counter == 0) return 1L;
    String cacheKey = stone + "~" + counter;
    if (cache.containsKey(cacheKey)) return cache.get(cacheKey);
    if (stone.equals("0")) return cacheAndReturn(cache, cacheKey, traverse("1", counter - 1, cache));
    else if (stone.length() % 2 == 0) {
      int mid = stone.length() / 2;
      String first = String.valueOf(Long.parseLong(stone.substring(0, mid)));
      String second = String.valueOf(Long.parseLong(stone.substring(mid)));
      return cacheAndReturn(cache, cacheKey, traverse(first, counter - 1, cache) + traverse(second, counter - 1, cache));
    } else return cacheAndReturn(cache, cacheKey, traverse(String.valueOf(Long.parseLong(stone) * 2024), counter - 1, cache));
  }

  private static <V> V cacheAndReturn(Map<String, V> cache, String key, V val) {
    cache.put(key, val);
    return val;
  }
}
