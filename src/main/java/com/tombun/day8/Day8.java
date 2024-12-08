package com.tombun.day8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Day8 {
  public static int partOne(List<String> input) {
    char[][] map = input.stream()
        .map(String::toCharArray)
        .toArray(char[][]::new);

    HashMap<Character, List<Coord>> antennas = new HashMap<>();

    for (int y = 0; y < map.length; y++) {
      for (int x = 0; x < map[y].length; x++) {
        if (map[y][x] != '.') antennas.computeIfAbsent(map[y][x], l -> new ArrayList<>()).add(new Coord(y, x));
      }
    }

    Set<Coord> antiNodes = new HashSet<>();

    for (Map.Entry<Character, List<Coord>> antenna : antennas.entrySet()) {
      List<Coord> list = antenna.getValue();
      for (int i = 0; i < list.size(); i++) {
        for (int j = i + 1; j < list.size(); j++) {
          int yDelta = list.get(i).y - list.get(j).y;
          int xDelta = list.get(i).x - list.get(j).x;
          for (Coord coord : List.of(new Coord(list.get(i).y + yDelta, list.get(i).x + xDelta), new Coord(list.get(j).y - yDelta, list.get(j).x - xDelta)))
            if (coord.y >= 0 && coord.x >= 0 && coord.y < map.length && coord.x < map[coord.y].length)
              antiNodes.add(coord);
        }
      }
    }

    return antiNodes.size();
  }

  public static int partTwo(List<String> input) {
    char[][] map = input.stream()
        .map(String::toCharArray)
        .toArray(char[][]::new);

    HashMap<Character, List<Coord>> antennas = new HashMap<>();

    for (int y = 0; y < map.length; y++) {
      for (int x = 0; x < map[y].length; x++) {
        if (map[y][x] != '.') antennas.computeIfAbsent(map[y][x], l -> new ArrayList<>()).add(new Coord(y, x));
      }
    }

    Set<Coord> antiNodes = new HashSet<>();

    for (Map.Entry<Character, List<Coord>> antenna : antennas.entrySet()) {
      List<Coord> list = antenna.getValue();
      for (int i = 0; i < list.size(); i++) {
        antiNodes.add(list.get(i));
        for (int j = i + 1; j < list.size(); j++) {
          int yDelta = list.get(i).y - list.get(j).y;
          int xDelta = list.get(i).x - list.get(j).x;
          int mult = 1;
          int yOffset = yDelta * mult;
          int xOffset = xDelta * mult;
          while (Math.abs(yOffset) < map.length && Math.abs(xOffset) < map[0].length) {
            yOffset = yDelta * mult;
            xOffset = xDelta * mult;
            for (Coord coord : List.of(new Coord(list.get(i).y + yOffset, list.get(i).x + xOffset), new Coord(list.get(j).y - yOffset, list.get(j).x - xOffset)))
              if (coord.y >= 0 && coord.x >= 0 && coord.y < map.length && coord.x < map[coord.y].length)
                antiNodes.add(coord);
            mult++;
          }
        }
      }
    }

    return antiNodes.size();
  }

  private record Coord(int y, int x) {
    @Override
    public String toString() {
      return y + "," + x;
    }
  }
}
