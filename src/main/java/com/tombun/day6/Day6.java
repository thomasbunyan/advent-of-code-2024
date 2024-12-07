package com.tombun.day6;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day6 {

  private static final Set<Character> EMPTY_SET = Set.of();

  public static int partOne(List<String> input) {
    List<Character> directions = List.of('^', '>', 'V', '<');
    char[][] map = input.stream()
        .map(String::toCharArray)
        .toArray(char[][]::new);

    for (int y = 0; y < map.length; y++) {
      for (int x = 0; x < map[y].length; x++) {
        if (directions.contains(map[y][x])) traverse(map, y, x, map[y][x]);
      }
    }

    int res = 0;
    for (char[] chars : map) {
      for (char c : chars) {
        if (c == 'X') res++;
      }
    }
    return res;
  }

  public static int partTwo(List<String> input) {
    List<Character> directions = List.of('^', '>', 'V', '<');
    char[][] map = input.stream()
        .map(String::toCharArray)
        .toArray(char[][]::new);

    for (int y = 0; y < map.length; y++) {
      for (int x = 0; x < map[y].length; x++) {
        if (directions.contains(map[y][x])) return traverseLoopLoop(map, y, x, map[y][x]).size();
      }
    }

    return -1;
  }

  private static void traverse(char[][] map, int y, int x, char dir) {
    map[y][x] = 'X';

    int[] dirWeight = getWeighting(dir);
    int nextY = y + dirWeight[0];
    int nextX = x + dirWeight[1];

    if (nextY < 0 || nextX < 0 || nextY >= map.length || nextX >= map[nextY].length) return;
    if (map[nextY][nextX] == '.' || map[nextY][nextX] == 'X') traverse(map, nextY, nextX, dir);
    else if (map[nextY][nextX] == '#') {
      dir = getNextDir(dir);
      dirWeight = getWeighting(dir);
      traverse(map, y + dirWeight[0], x + dirWeight[1], dir);
    }
  }

  private static Set<String> traverseLoopLoop(char[][] map, int y, int x, char dir) {
    Set<String> visited = new HashSet<>();
    Set<String> visitedDir = new HashSet<>();
    Set<String> obsPos = new HashSet<>();

    int[] dirWeight = getWeighting(dir);
    int nextY = y + dirWeight[0];
    int nextX = x + dirWeight[1];

    while (nextY >= 0 && nextX >= 0 && nextY < map.length && nextX < map[nextY].length) {
      visited.add(y + "," + x);
      visitedDir.add(y + "," + x + "~" + dir);

      char nextDir = getNextDir(dir);
      int[] loopCheckWeight = getWeighting(nextDir);
      int loopY = y + loopCheckWeight[0];
      int loopX = x + loopCheckWeight[1];
      while (loopY >= 0 && loopX >= 0 && loopY < map.length && loopX < map[loopY].length && map[loopY][loopX] != '#') {
        if (visitedDir.contains(loopY + "," + loopX + "~" + nextDir)) {
          obsPos.add(nextY + "," + nextX);
          break;
        }
        loopY += loopCheckWeight[0];
        loopX += loopCheckWeight[1];
      }

      if (map[nextY][nextX] == '.' || map[nextY][nextX] == '^') {
        y = nextY;
        x = nextX;
      } else if (map[nextY][nextX] == '#') {
        dir = getNextDir(dir);
        dirWeight = getWeighting(dir);
        y += dirWeight[0];
        x += dirWeight[1];
      } else {
        break;
      }

      dirWeight = getWeighting(dir);
      nextY = y + dirWeight[0];
      nextX = x + dirWeight[1];
    }

    visited.add(y + "," + x);

    System.out.println(visited.size());

    return obsPos;
  }

  private static int[] getWeighting(char dir) {
    return switch (dir) {
      case '>' -> new int[]{0, 1};
      case 'V' -> new int[]{1, 0};
      case '<' -> new int[]{0, -1};
      case '^' -> new int[]{-1, 0};
      default -> throw new RuntimeException("Bad mapping");
    };
  }

  private static char getNextDir(char dir) {
    return switch (dir) {
      case '>' -> 'V';
      case 'V' -> '<';
      case '<' -> '^';
      case '^' -> '>';
      default -> throw new RuntimeException("Bad mapping");
    };
  }
}
