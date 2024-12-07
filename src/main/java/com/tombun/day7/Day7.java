package com.tombun.day7;

import java.util.Arrays;
import java.util.List;

public class Day7 {

  public static long partOne(List<String> input) {
    long res = 0;
    for (String equation : input) {
      String[] eqParts = equation.split(": ");
      long target = Long.parseLong(eqParts[0]);
      long[] numbers = Arrays.stream(eqParts[1].split(" ")).mapToLong(Long::parseLong).toArray();
      if (solve(target, numbers, 1, numbers[0])) res += target;
    }
    return res;
  }

  public static long partTwo(List<String> input) {
    long res = 0;
    for (String equation : input) {
      String[] eqParts = equation.split(": ");
      long target = Long.parseLong(eqParts[0]);
      long[] numbers = Arrays.stream(eqParts[1].split(" ")).mapToLong(Long::parseLong).toArray();
      if (solveTwo(target, numbers, 1, numbers[0])) res += target;
    }
    return res;
  }

  private static boolean solve(long target, long[] nums, int i, long currentVal) {
    if (i >= nums.length) return currentVal == target;
    if (solve(target, nums, i + 1, currentVal + nums[i])) return true;
    return solve(target, nums, i + 1, currentVal * nums[i]);
  }

  private static boolean solveTwo(long target, long[] nums, int i, long currentVal) {
    if (i >= nums.length) return currentVal == target;
    if (solveTwo(target, nums, i + 1, Long.parseLong(currentVal + "" + nums[i]))) return true;
    if (solveTwo(target, nums, i + 1, currentVal + nums[i])) return true;
    return solveTwo(target, nums, i + 1, currentVal * nums[i]);
  }
}
