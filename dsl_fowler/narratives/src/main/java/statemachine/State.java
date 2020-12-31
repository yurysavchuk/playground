package statemachine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class State {

  private String name;
  private List<Command> actions = new ArrayList<>();
  private Map<String, Transition> transitions = new HashMap<>();

  public State(String name) {
    this.name = name;
  }

  public void addTransition(Event event, State targetState) {
    Objects.requireNonNull(targetState);
    transitions.put(event.getCode(), new Transition(this, event, targetState));
  }

  public Collection<State> getAllTargets() {
    List<State> result = new ArrayList<>();
    for (Transition t: transitions.values()) result.add(t.getTarget());
    return result;
  }

  public boolean hasTransition(String eventCode) {
    return transitions.containsKey(eventCode);
  }

  public State targetState(String eventCode) {
    return transitions.get(eventCode).getTarget();
  }

  public void executeActions(CommandChannel commandsChannel) {
    for (Command c: actions) commandsChannel.send(c.getCode());
  }

  public void addAction(Command action) {
    actions.add(action);
  }

  void probeEquivalence(State other, Notification note) {
    assert name.equals(other.name);
    probeEquivalentTransitions(other, note);
    probeEquivalentActions(other, note);
  }

  private void probeEquivalentActions(State other, Notification note) {
    if (!actions.equals(other.actions)) {
      note.error("%s has different actions %s vs %s", name, actions, other.actions);
    }
  }

  private void probeEquivalentTransitions(State other, Notification note) {
    for (Transition t: transitions.values()) {
      t.probeEquivalent(other.transitions.get(t.getEventCode()), note);
    }
    for (Transition t: other.transitions.values()) {
      if (!this.transitions.containsKey(t.getEventCode())) {
        note.error("%s has extra transition with %s", name, t.getTrigger());
      }
    }
  }
}
