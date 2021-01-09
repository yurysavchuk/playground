package com.github.yurysavchuk.classsymboltable;

public class TransitionBuilder {

  private Events trigger;
  private States targetState;
  private States source;

  public TransitionBuilder(States states, Events trigger) {
    this.trigger = trigger;
    this.source = states;
  }

  public States to(States targetState) {
    this.targetState = targetState;
    source.addTransition(this);
    return source;
  }

  void produce() {
    source.getState().addTransition(trigger.getEvent(), getTargetState().getState());
  }

  public States getTargetState() {
    return targetState;
  }
}
