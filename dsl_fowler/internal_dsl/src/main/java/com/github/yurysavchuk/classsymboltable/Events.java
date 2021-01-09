package com.github.yurysavchuk.classsymboltable;

public class Events extends Identifier {

  private Event event;

  public Events(String name, StateMachineBuilder builder) {
    super(name, builder);
  }

  public Event getEvent() {
    return event;
  }

  public void code(String code) {
    event = new Event(getName(), code);
  }
}
