package com.github.yurysavchuk.closure;

public class ManagersPredicate implements FilterFunction<Employee> {

  @Override
  public Boolean passes(Employee arg) {
    return arg.isManager();
  }
}
