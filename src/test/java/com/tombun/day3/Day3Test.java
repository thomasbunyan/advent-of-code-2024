package com.tombun.day3;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static utils.LoadInput.loadInput;

class Day3Test {

  @Test
  public void TestPartOne() throws IOException {
    int res = Day3.partOne(loadInput("/day3/input.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartTwo() throws IOException {
    int res = Day3.partTwo(loadInput("/day3/input.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartOneExample() throws IOException {
    int res = Day3.partOne(loadInput("/day3/example.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartTwoExample() throws IOException {
    int res = Day3.partTwo(loadInput("/day3/example.txt"));
    System.out.println(res);
  }
}