package com.tombun.day4;

import java.util.List;

public class Day4 {

  public static int partOne(List<String> input) {
    int count = 0;

    String[] map = input.toArray(String[]::new);
    for (int y = 0; y < map.length; y++) {
      for (int x = 0; x < map[y].length(); x++) {
        if (map[y].charAt(x) == 'X') {
          for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
              if (!(i == 0 && j == 0)) count += traverse(map, y + i, x + j, i, j, 'M');
            }
          }
        }
      }
    }

    return count;
  }

  public static int partTwo(List<String> input) {
    int count = 0;

    String[] map = input.toArray(String[]::new);
    for (int y = 0; y < map.length; y++) {
      for (int x = 0; x < map[y].length(); x++) {
        if (y > 0 && x > 0 && y < map.length - 1 && x < map[y].length() - 1) {
          if (map[y].charAt(x) == 'A') {
            int counter = 0;
            counter += traverse(map, y - 1, x - 1, 1, 1, 'M');
            counter += traverse(map, y - 1, x + 1, 1, -1, 'M');
            counter += traverse(map, y + 1, x - 1, -1, 1, 'M');
            counter += traverse(map, y + 1, x + 1, -1, -1, 'M');
            if (counter == 2) count++;
          }
        }
      }
    }

    return count;
  }

  private static int traverse(String[] map, int y, int x, int dirY, int dirX, char target) {
    if (y < 0 || x < 0 || y >= map.length || x >= map[y].length()) return 0;
    if (map[y].charAt(x) != target) return 0;
    if (map[y].charAt(x) == 'S') return 1;
    return traverse(map, y + dirY, x + dirX, dirY, dirX, getNext(target));
  }

  private static char getNext(char current) {
    return switch (current) {
      case 'X' -> 'M';
      case 'M' -> 'A';
      case 'A' -> 'S';
      case 'S' -> '.';
      default -> ' ';
    };
  }
}
