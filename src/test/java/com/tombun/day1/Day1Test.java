package com.tombun.day1;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static utils.LoadInput.loadInput;

class Day1Test {

  @Test
  public void TestPartOneExample() throws IOException {
    int res = Day1.partOne(loadInput("/day1/example.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartOne() throws IOException {
    int res = Day1.partOne(loadInput("/day1/input.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartTwoExample() throws IOException {
    int res = Day1.partTwo(loadInput("/day1/example.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartTwo() throws IOException {
    int res = Day1.partTwo(loadInput("/day1/input.txt"));
    System.out.println(res);
  }

}
