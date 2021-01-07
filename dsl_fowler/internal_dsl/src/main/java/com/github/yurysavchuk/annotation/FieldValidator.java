package com.github.yurysavchuk.annotation;

import java.lang.reflect.Field;

public interface FieldValidator {
  boolean isValid(Object obj, Field field);
}
