package com.tombun.day10;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static utils.LoadInput.loadInput;

class Day10Test {

  @Test
  public void TestPartOne() throws IOException {
    long res = Day10.partOne(loadInput("/day10/input.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartTwo() throws IOException {
    long res = Day10.partTwo(loadInput("/day10/input.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartOneExample() throws IOException {
    long res = Day10.partOne(loadInput("/day10/example.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartTwoExample() throws IOException {
    long res = Day10.partTwo(loadInput("/day10/example.txt"));
    System.out.println(res);
  }

}
