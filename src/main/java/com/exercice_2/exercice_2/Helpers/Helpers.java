package com.exercice_2.exercice_2.Helpers;

public class Helpers {

  public static boolean isFloat(String input) {
    try {
      Float.parseFloat(input);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
