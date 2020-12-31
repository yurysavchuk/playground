package com.github.yurysavchuk.objectscopping;

import java.util.ArrayList;
import java.util.List;

public class Zone {

  private List<RuleElement> ruleElements = new ArrayList<>();

  public void addRule(RuleElement ruleElement) {
    ruleElements.add(ruleElement);
  }

}
