package com.tombun.day8;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static utils.LoadInput.loadInput;

class Day8Test {

  @Test
  public void TestPartOne() throws IOException {
    long res = Day8.partOne(loadInput("/day8/input.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartTwo() throws IOException {
    long res = Day8.partTwo(loadInput("/day8/input.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartOneExample() throws IOException {
    long res = Day8.partOne(loadInput("/day8/example.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartTwoExample() throws IOException {
    long res = Day8.partTwo(loadInput("/day8/example.txt"));
    System.out.println(res);
  }

}