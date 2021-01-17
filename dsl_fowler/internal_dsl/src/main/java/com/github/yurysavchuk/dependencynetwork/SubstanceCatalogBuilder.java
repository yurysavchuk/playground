package com.github.yurysavchuk.dependencynetwork;

import java.util.ArrayList;
import java.util.List;

public abstract class SubstanceCatalogBuilder {

  public List<Substance> build() {
    initializeSubstanceBuilders();
    doBuild();
//    return substanceFields.convertAll(f -> g.getValue(this));
    return new ArrayList<>();
  }

  private void initializeSubstanceBuilders() {

  }

  protected abstract void doBuild();
}
