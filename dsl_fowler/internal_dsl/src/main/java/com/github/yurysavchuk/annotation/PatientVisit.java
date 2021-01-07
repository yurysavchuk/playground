package com.github.yurysavchuk.annotation;

public class PatientVisit extends DomainObject {

  @ValidRange(lower = 1, upper = 1000, units = Units.LB)
  private Quantity weight;

  @ValidRange(lower = 1, upper = 1000, units = Units.IN)
  private Quantity height;

  public PatientVisit() {
  }

  public PatientVisit(Quantity weight, Quantity height) {
    this.weight = weight;
    this.height = height;
  }

  public Quantity getWeight() {
    return weight;
  }

  public void setWeight(Quantity weight) {
    this.weight = weight;
  }

  public Quantity getHeight() {
    return height;
  }

  public void setHeight(Quantity height) {
    this.height = height;
  }
}
