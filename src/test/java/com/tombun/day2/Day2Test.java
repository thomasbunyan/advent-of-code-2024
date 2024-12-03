package com.tombun.day2;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static utils.LoadInput.loadInput;

class Day2Test {

  @Test
  public void TestPartOneExample() throws IOException {
    int res = Day2.partOne(loadInput("/day2/example.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartOne() throws IOException {
    int res = Day2.partOne(loadInput("/day2/input.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartTwoExample() throws IOException {
    int res = Day2.partTwo(loadInput("/day2/example.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartTwo() throws IOException {
    int res = Day2.partTwo(loadInput("/day2/input.txt"));
    System.out.println(res);
  }

}
