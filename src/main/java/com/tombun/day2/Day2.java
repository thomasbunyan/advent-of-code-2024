package com.tombun.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2 {

  public static int partOne(List<String> input) {
    int safeReports = 0;

    for (String reportString : input) {
      List<Integer> report = Arrays.stream(reportString.split(" ")).map(Integer::parseInt).toList();
      if (isSafeReport(report)) safeReports++;
    }

    return safeReports;
  }

  public static int partTwo(List<String> input) {
    int safeReports = 0;

    for (String reportString : input) {
      List<Integer> report = Arrays.stream(reportString.split(" ")).map(Integer::parseInt).toList();
      if (isSafeReport(report)) safeReports++;
      else {
        for (int i = 0; i < report.size(); i++) {
          List<Integer> dampenedReport = new ArrayList<>(report);
          dampenedReport.remove(i);
          if (isSafeReport(dampenedReport)) {
            safeReports++;
            break;
          }
        }
      }
    }

    return safeReports;
  }

  private static boolean isSafeReport(List<Integer> report) {
    Integer prevDelta = null;
    for (int i = 0, j = 1; j < report.size(); i++, j++) {
      int delta = report.get(i) - report.get(j);
      if ((Math.abs(delta) < 1 || Math.abs(delta) > 3) || (prevDelta != null && prevDelta * delta < 0)) return false;
      prevDelta = delta;
    }
    return true;
  }
}
