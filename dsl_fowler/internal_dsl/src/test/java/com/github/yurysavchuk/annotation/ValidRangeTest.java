package com.github.yurysavchuk.annotation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidRangeTest {

  @Test
  public void failedValidRangeTest() {
    // given
    Quantity weight = new Quantity(1500, Units.LB);
    Quantity height = new Quantity(500, Units.IN);

    PatientVisit visit = new PatientVisit(weight, height);

    // when
    boolean isValid = visit.isValid();

    // then
    assertFalse(isValid);
  }

  @Test
  public void successValidRangeTest() {
    // given
    Quantity weight = new Quantity(500, Units.LB);
    Quantity height = new Quantity(500, Units.IN);

    PatientVisit visit = new PatientVisit(weight, height);

    // when
    boolean isValid = visit.isValid();

    // then
    assertTrue(isValid);
  }

}
