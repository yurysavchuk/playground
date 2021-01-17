package com.github.yurysavchuk.dependencynetwork;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Substance {
  private String name;
  private List<Substance> inputs = new ArrayList<>();
  private MacGuffinProfile profile;
  private Recipe recipe;
  private boolean outOfDate;

  public void addInput(Substance s) {
    inputs.add(s);
  }

  public MacGuffinProfile profile() {
    invokeProfileCalculation();
    return profile;
  }

  private void invokeProfileCalculation() {
    for (Substance substance: inputs) {
      substance.invokeProfileCalculation();
    }
    if (isOutOfDate()) {
//      profile = profilingService.calculateProfile(this);
    }
  }

  public boolean isOutOfDate() {
    if (null == profile) {
      return true;
    }
    return profile.getTimestamp().isBefore(recipe.getTimestamp())
      || inputs.stream().anyMatch(input -> input.wasUpdatedAfter(profile.getTimestamp()));
  }

  private boolean wasUpdatedAfter(LocalDateTime d) {
    return profile.getTimestamp().isAfter(d);
  }
}
