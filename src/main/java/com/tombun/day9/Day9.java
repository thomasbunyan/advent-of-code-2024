package com.tombun.day9;

import java.util.ArrayList;
import java.util.List;

public class Day9 {
  public static long partOne(List<String> input) {
    List<int[]> lines = input.stream()
        .map(s -> s.chars().map(Character::getNumericValue).toArray())
        .toList();

    List<Integer> result = new ArrayList<>();

    for (int[] line : lines) {
      int l = 0;
      int r = line.length - 1;
      while (l <= r) {
        if (l % 2 == 0) {
          while (line[l] > 0) {
            result.add(l / 2);
            line[l]--;
          }
          l += 1;
        } else {
          int a = Math.min(line[l], line[r]);
          while (a > 0) {
            result.add(r / 2);
            line[l]--;
            line[r]--;
            a--;
          }
          if (line[l] == 0) l += 1;
          if (line[r] == 0) r -= 2;
        }
      }
    }

    return calculateChecksum(result);
  }

  public static long partTwo(List<String> input) {
    List<int[]> lines = input.stream()
        .map(s -> s.chars().map(Character::getNumericValue).toArray())
        .toList();

    List<Integer> result = new ArrayList<>();

    for (int[] line : lines) {
      int[] removals = new int[line.length];
      int l = 0;
      while (l < line.length) {
        if (l % 2 == 0) {
          while (line[l] > 0) {
            result.add(l / 2);
            line[l]--;
          }
        } else {
          int r = line.length - 1;
          while (r > l) {
            if (line[l] >= line[r]) {
              while (line[r] > 0) {
                result.add(r / 2);
                line[l]--;
                line[r]--;
                removals[r - 1]++;
              }
            } else if (line[l] == 0) break;
            r -= 2;
          }
          int emptyPositions = line[l] + removals[l];
          while (emptyPositions > 0) {
            result.add(null);
            emptyPositions--;
          }
        }
        l++;
      }
    }

    return calculateChecksum(result);
  }

  private static long calculateChecksum(List<Integer> result) {
    long checksum = 0;
    long i = 0;
    for (Integer n : result) {
      if (n != null) checksum += n * i;
      i++;
    }
    return checksum;
  }
}
