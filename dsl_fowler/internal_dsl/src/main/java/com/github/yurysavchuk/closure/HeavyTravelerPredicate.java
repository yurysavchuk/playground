package com.github.yurysavchuk.closure;

public class HeavyTravelerPredicate implements FilterFunction<Employee> {

  private int threshold;

  public HeavyTravelerPredicate(int threshold) {
    this.threshold = threshold;
  }

  @Override
  public Boolean passes(Employee arg) {
    return arg.getMilesOfCommute() > threshold;
  }
}
