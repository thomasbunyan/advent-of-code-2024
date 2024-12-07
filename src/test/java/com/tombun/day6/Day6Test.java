package com.tombun.day6;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static utils.LoadInput.loadInput;

class Day6Test {

  @Test
  public void TestPartOne() throws IOException {
    int res = Day6.partOne(loadInput("/day6/input.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartTwo() throws IOException {
    int res = Day6.partTwo(loadInput("/day6/input.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartOneExample() throws IOException {
    int res = Day6.partOne(loadInput("/day6/example.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartTwoExample() throws IOException {
    int res = Day6.partTwo(loadInput("/day6/example.txt"));
    System.out.println(res);
  }

}
