package com.github.yurysavchuk.dependencynetwork;

public class Script extends SubstanceCatalogBuilder {
  Substances octopusEssence, clarifiedWater, octopus, dessicatedGlass, healthPotion;

  @Override
  protected void doBuild() {

    healthPotion.needs(octopusEssence, clarifiedWater);

    octopusEssence.needs(clarifiedWater, octopus);

    clarifiedWater.needs(dessicatedGlass);
  }

}
