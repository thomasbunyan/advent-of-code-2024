package com.tombun.day7;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static utils.LoadInput.loadInput;

class Day7Test {

  @Test
  public void TestPartOne() throws IOException {
    long res = Day7.partOne(loadInput("/day7/input.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartTwo() throws IOException {
    long res = Day7.partTwo(loadInput("/day7/input.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartOneExample() throws IOException {
    long res = Day7.partOne(loadInput("/day7/example.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartTwoExample() throws IOException {
    long res = Day7.partTwo(loadInput("/day7/example.txt"));
    System.out.println(res);
  }
}