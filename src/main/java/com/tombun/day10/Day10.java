package com.tombun.day10;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day10 {
  public static int partOne(List<String> input) {
    int[][] map = input.stream()
        .map(row -> row.chars().map(ch -> ch - '0').toArray())
        .toArray(int[][]::new);

    int res = 0;

    for (int y = 0; y < map.length; y++) {
      for (int x = 0; x < map[y].length; x++) {
        if (map[y][x] == 0) res += traverse(map, y, x, 0, new HashSet<>());
      }
    }

    return res;
  }

  public static int partTwo(List<String> input) {
    int[][] map = input.stream()
        .map(row -> row.chars().map(ch -> ch - '0').toArray())
        .toArray(int[][]::new);

    int res = 0;

    for (int y = 0; y < map.length; y++) {
      for (int x = 0; x < map[y].length; x++) {
        if (map[y][x] == 0) res += traverse(map, y, x, 0);
      }
    }

    return res;
  }

  private static int traverse(int[][] map, int y, int x, int target, Set<String> visited) {
    if (y < 0 || x < 0 || y >= map.length || x >= map[y].length) return 0;
    if (map[y][x] != target || visited.contains(y + "," + x)) return 0;
    if (map[y][x] == 9) {
      visited.add(y + "," + x);
      return 1;
    }

    int res = 0;
    res += traverse(map, y + 1, x, map[y][x] + 1, visited);
    res += traverse(map, y - 1, x, map[y][x] + 1, visited);
    res += traverse(map, y, x + 1, map[y][x] + 1, visited);
    res += traverse(map, y, x - 1, map[y][x] + 1, visited);
    return res;
  }

  private static int traverse(int[][] map, int y, int x, int target) {
    if (y < 0 || x < 0 || y >= map.length || x >= map[y].length) return 0;
    if (map[y][x] != target) return 0;
    if (map[y][x] == 9) return 1;

    int res = 0;
    res += traverse(map, y + 1, x, map[y][x] + 1);
    res += traverse(map, y - 1, x, map[y][x] + 1);
    res += traverse(map, y, x + 1, map[y][x] + 1);
    res += traverse(map, y, x - 1, map[y][x] + 1);
    return res;
  }
}
