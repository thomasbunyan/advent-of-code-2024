package com.tombun.day1;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Day1 {

  public static int partOne(List<String> in) {
    PriorityQueue<Integer> left = new PriorityQueue<>();
    PriorityQueue<Integer> right = new PriorityQueue<>();

    for (String i : in) {
      String[] lists = i.split(" {3}");
      left.add(Integer.parseInt(lists[0]));
      right.add(Integer.parseInt(lists[1]));
    }

    int res = 0;

    for (int i = 0; i < in.size(); i++) {
      res += Math.abs(left.remove() - right.remove());
    }

    return res;
  }

  public static int partTwo(List<String> in) {
    HashMap<Integer, Integer> count = new HashMap<>();

    for (String i : in) {
      String[] lists = i.split(" {3}");
      Integer no = Integer.parseInt(lists[1]);
      count.put(no, count.getOrDefault(no, 0) + 1);
    }

    int res = 0;

    for (String i : in) {
      String[] lists = i.split(" {3}");
      Integer no = Integer.parseInt(lists[0]);
      res += no * count.getOrDefault(no, 0);
    }

    return res;
  }
}
