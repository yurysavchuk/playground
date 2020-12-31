package com.github.yurysavchuk.objectscopping;

public class ZoneBuilder {
  private Zone value = new Zone();
  public Zone getValue() {
    return value;
  }

  public ZoneBuilder refuse(RuleElement... rules) {
    value.addRule(new RefusalRule(new AddExpr(rules)));
    return this;
  }

  public ZoneBuilder allow(RuleElement... rules) {
    value.addRule(new AllowRule(new AddExpr(rules)));
    return this;
  }

  public RuleElement gradeAtLeast(Grade g) {
    return new MinimumGradeExpr(g);
  }

  public RuleElement department(Department d) {
    return new DepartmentExpr(d);
  }

}
