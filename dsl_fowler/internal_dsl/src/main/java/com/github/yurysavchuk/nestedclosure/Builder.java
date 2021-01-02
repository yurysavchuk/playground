package com.github.yurysavchuk.nestedclosure;

public abstract class Builder {

  protected Computer result;

  protected abstract void doBuild();

  protected void computer(Runnable child) {
    result = new Computer();
    child.run();
  }

  protected void processor(Runnable child) {
    result.setProcessor(new Processor());
    child.run();
  }

  protected void disk(Runnable child) {
    child.run();
  }

  protected void cores(int number) {
    result.getProcessor().setCores(number);
  }

  protected void i386() {

  }

  protected void processorSpeed(double speed) {

  }

  protected void size(int size) {

  }

  protected void diskSpeed(int speed) {

  }

  protected void sata() {

  }

}
