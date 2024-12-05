package com.tombun.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Day5 {

  public static int partOne(List<String> input) {
    int res = 0;

    HashMap<String, List<String>> orderingRules = new HashMap<>();

    for (String line : input) {
      if (line.isEmpty()) break;
      String[] order = line.split("\\|");
      orderingRules.computeIfAbsent(order[0], k -> new ArrayList<>()).add(order[1]);
    }

    updateLoop:
    for (int i = input.size() - 1; i >= 0; i--) {
      String line = input.get(i);
      if (line.isEmpty()) break;
      HashSet<String> seenValues = new HashSet<>();
      String[] nums = line.split(",");
      for (String num : nums) {
        for (String orderNum : orderingRules.getOrDefault(num, List.of())) {
          if (seenValues.contains(orderNum)) continue updateLoop;
        }
        seenValues.add(num);
      }
      res += Integer.parseInt(nums[nums.length / 2]);
    }

    return res;
  }

  public static int partTwo(List<String> input) {
    int res = 0;

    HashMap<String, List<String>> orderingRules = new HashMap<>();

    for (String line : input) {
      if (line.isEmpty()) break;
      String[] order = line.split("\\|");
      orderingRules.computeIfAbsent(order[0], k -> new ArrayList<>()).add(order[1]);
    }

    updateLoop:
    for (int i = input.size() - 1; i >= 0; i--) {
      String line = input.get(i);
      if (line.isEmpty()) break;
      HashSet<String> seenValues = new HashSet<>();
      String[] nums = line.split(",");
      for (String num : nums) {
        for (String orderNum : orderingRules.getOrDefault(num, List.of())) {
          if (seenValues.contains(orderNum)) {
            List<String> sorted = Arrays.stream(nums).sorted((s1, s2) -> {
              if (orderingRules.getOrDefault(s1, List.of()).contains(s2)) return 1;
              else if (orderingRules.getOrDefault(s2, List.of()).contains(s1)) return -1;
              return 0;
            }).toList();
            res += Integer.parseInt(sorted.get(sorted.size() / 2));
            continue updateLoop;
          }
        }
        seenValues.add(num);
      }
    }

    return res;
  }
}
