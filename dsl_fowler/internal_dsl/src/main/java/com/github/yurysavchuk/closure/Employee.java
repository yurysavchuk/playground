package com.github.yurysavchuk.closure;

public class Employee {

  private int milesOfCommute;

  public Employee(int milesOfCommute) {
    this.milesOfCommute = milesOfCommute;
  }

  public Boolean isManager() {
    return false;
  }

  public int getMilesOfCommute() {
    return milesOfCommute;
  }
}
