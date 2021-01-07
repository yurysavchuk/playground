package com.github.yurysavchuk.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ValidationProcessor {

  public boolean isValid(Object arg) {
    for (Field f: arg.getClass().getDeclaredFields()) {
      for (Annotation a: f.getAnnotations()) {
        if (doesAnnotationValidationFail(arg, f, a)) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean doesAnnotationValidationFail(Object obj, Field f, Annotation a) {
    FieldValidator validator = validatorMap().get(a.annotationType());
    if (null == validator) {
      return false;
    }
    return !validator.isValid(obj,f);
  }

  private Map<Class, FieldValidator> validatorMap() {
    Map<Class, FieldValidator> result = new HashMap<>();
    result.put(ValidRange.class, new ValidRangeFieldValidator());
    return result;
  }

}
