package com.github.yurysavchuk.classsymboltable;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class States extends Identifier {
  private State content;
  private List<TransitionBuilder> transitions = new ArrayList<>();
  private List<Commands> commands = new ArrayList<>();

  public States(String name, StateMachineBuilder builder) {
    super(name, builder);
    content = new State(name);
  }

  public States actions(Commands... identifiers) {
    builder.definingState(this);
    commands.addAll(Arrays.asList(identifiers));
    return this;
  }

  public TransitionBuilder transition(Events identifier) {
    builder.definingStates(this);
    return new TransitionBuilder(this, identifier);
  }

  void produce() {
    for (Commands c: commands) {
      content.addAction(c.getCommand());
    }
    for (TransitionBuilder t: transitions) {
      t.produce();
    }
  }

  public void addTransition(TransitionBuilder transitionBuilder) {

  }


}
