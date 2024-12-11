package com.tombun.day11;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static utils.LoadInput.loadInput;

class Day11Test {

  @Test
  public void TestPartOne() throws IOException {
    long res = Day11.partOne(loadInput("/day11/input.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartTwo() throws IOException {
    long res = Day11.partTwo(loadInput("/day11/input.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartOneExample() throws IOException {
    long res = Day11.partOne(loadInput("/day11/example.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartTwoExample() throws IOException {
    long res = Day11.partTwo(loadInput("/day11/example.txt"));
    System.out.println(res);
  }
}
