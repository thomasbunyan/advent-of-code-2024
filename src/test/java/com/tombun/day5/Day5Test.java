package com.tombun.day5;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static utils.LoadInput.loadInput;

class Day5Test {

  @Test
  public void TestPartOne() throws IOException {
    int res = Day5.partOne(loadInput("/day5/input.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartTwo() throws IOException {
    int res = Day5.partTwo(loadInput("/day5/input.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartOneExample() throws IOException {
    int res = Day5.partOne(loadInput("/day5/example.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartTwoExample() throws IOException {
    int res = Day5.partTwo(loadInput("/day5/example.txt"));
    System.out.println(res);
  }

}