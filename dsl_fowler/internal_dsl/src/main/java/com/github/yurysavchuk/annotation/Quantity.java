package com.github.yurysavchuk.annotation;

public class Quantity {
  private int amount;
  private Units units;

  public Quantity() {
  }

  public Quantity(int amount, Units units) {
    this.amount = amount;
    this.units = units;
  }

  public int getAmount() {
    return amount;
  }

  public Units getUnits() {
    return units;
  }
}
