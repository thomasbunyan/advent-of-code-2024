package com.tombun.day1;

import java.io.IOException;
import java.util.List;

import static utils.LoadInput.loadInput;

public class Day1 {

  public static void run() throws IOException {
    List<String> in = loadInput("/day1/input.txt");
    for (String i : in) {
      System.out.println(i);
    }
  }

}
