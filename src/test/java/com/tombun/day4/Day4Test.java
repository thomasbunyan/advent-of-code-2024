package com.tombun.day4;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static utils.LoadInput.loadInput;

class Day4Test {

  @Test
  public void TestPartOne() throws IOException {
    int res = Day4.partOne(loadInput("/day4/input.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartTwoE() throws IOException {
    int res = Day4.partTwo(loadInput("/day4/input.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartOneExample() throws IOException {
    int res = Day4.partOne(loadInput("/day4/example.txt"));
    System.out.println(res);
  }

  @Test
  public void TestPartTwoExample() throws IOException {
    int res = Day4.partTwo(loadInput("/day4/example.txt"));
    System.out.println(res);
  }

}
