package com.tombun.day9;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static utils.LoadInput.loadInput;

class Day9Test {

  @Test
  public void TestPartOne() throws IOException {
    long res = Day9.partOne(loadInput("/day9/input.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartTwo() throws IOException {
    long res = Day9.partTwo(loadInput("/day9/input.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartOneExample() throws IOException {
    long res = Day9.partOne(loadInput("/day9/example.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartTwoExample() throws IOException {
    long res = Day9.partTwo(loadInput("/day9/example.txt"));
    System.out.println(res);
  }
}
