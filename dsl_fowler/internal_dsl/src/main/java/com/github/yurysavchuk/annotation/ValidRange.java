package com.github.yurysavchuk.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidRange {
  int lower() default Integer.MIN_VALUE;
  int upper() default Integer.MAX_VALUE;
  Units units() default Units.MISSING;
}
