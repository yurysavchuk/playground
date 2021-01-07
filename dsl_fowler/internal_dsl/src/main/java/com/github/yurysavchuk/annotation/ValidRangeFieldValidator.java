package com.github.yurysavchuk.annotation;

import java.lang.reflect.Field;

public class ValidRangeFieldValidator implements
  FieldValidator {

  @Override
  public boolean isValid(Object obj, Field field) {
    ValidRange r = field.getAnnotation(ValidRange.class);
    field.setAccessible(true);
    Quantity value;
    try {
      value = (Quantity) field.get(obj);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    }
    return (r.units() == value.getUnits())
      && (r.lower() <= value.getAmount())
      && (value.getAmount() <= r.upper());
  }
}
