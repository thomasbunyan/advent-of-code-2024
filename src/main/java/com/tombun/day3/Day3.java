package com.tombun.day3;

import java.util.List;

public class Day3 {

  public static int partOne(List<String> input) {
    int res = 0;

    for (String line : input) {
      int i = 0;
      while (i < line.length()) {
        if (line.startsWith("mul(", i)) {
          i += 4;
          StringBuilder num1 = new StringBuilder();
          StringBuilder num2 = new StringBuilder();
          boolean seenComma = false;
          while (num1.length() <= 3 && num2.length() <= 3 && i < line.length()) {
            if (('0' <= line.charAt(i) && line.charAt(i) <= '9')) {
              if (!seenComma) num1.append(line.charAt(i));
              else num2.append(line.charAt(i));
            } else if (line.charAt(i) == ',') seenComma = true;
            else if (line.charAt(i) == ')') {
              res += Integer.parseInt(num1.toString()) * Integer.parseInt(num2.toString());
              break;
            } else break;
            i++;
          }
        }
        i++;
      }
    }

    return res;
  }

  public static int partTwo(List<String> input) {
    int res = 0;
    boolean doMul = true;

    for (String line : input) {
      int i = 0;
      while (i < line.length()) {
        if (line.startsWith("mul(", i)) {
          i += 4;
          StringBuilder num1 = new StringBuilder();
          StringBuilder num2 = new StringBuilder();
          boolean seenComma = false;
          while (num1.length() <= 3 && num2.length() <= 3 && i < line.length()) {
            if (('0' <= line.charAt(i) && line.charAt(i) <= '9')) {
              if (!seenComma) num1.append(line.charAt(i));
              else num2.append(line.charAt(i));
            } else if (line.charAt(i) == ',') seenComma = true;
            else if (line.charAt(i) == ')') {
              if (doMul) res += Integer.parseInt(num1.toString()) * Integer.parseInt(num2.toString());
              break;
            } else break;
            i++;
          }
        } else if (line.startsWith("do()", i)) {
          doMul = true;
          i += 3;
        } else if (line.startsWith("don't()", i)) {
          doMul = false;
          i += 6;
        }
        i++;
      }
    }

    return res;
  }
}
