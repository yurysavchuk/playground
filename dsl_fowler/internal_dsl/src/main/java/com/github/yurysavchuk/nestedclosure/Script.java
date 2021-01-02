package com.github.yurysavchuk.nestedclosure;

public class Script extends Builder {

  @Override
  protected void doBuild() {
    computer(() -> {
      processor(() -> {
        cores(2);
        i386();
        processorSpeed(2.2);
      });
      disk(() -> {
        size(150);
      });
      disk(() -> {
        size(75);
        diskSpeed(7200);
        sata();
      });
    });
  }

  protected Computer getResult() {
    return result;
  }

}
