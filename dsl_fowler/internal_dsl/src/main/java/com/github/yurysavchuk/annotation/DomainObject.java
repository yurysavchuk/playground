package com.github.yurysavchuk.annotation;

public class DomainObject {

  boolean isValid() {
    return new ValidationProcessor().isValid(this);
  }

}
