package statemachine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StateMachine {

  private State start;
  private List<Event> resetEvents = new ArrayList<>();

  public StateMachine(State start) {
    this.start = start;
  }

  public void addResetEvents(Event ... events) {
    for (Event e: events) resetEvents.add(e);
  }

  private void addResetEvent_byAddingTransitions(Event e) {
    for (State s: getStates()) {
      if (!s.hasTransition(e.getCode())) s.addTransition(e, start);
    }
  }

  public Collection<State> getStates() {
    List<State> result = new ArrayList<>();
    collectStates(result, start);
    return result;
  }

  private void collectStates(Collection<State> result, State s) {
    if (result.contains(s)) return;
    result.add(s);
    for (State next: s.getAllTargets()) {
      collectStates(result, next);
    }
  }

  public boolean isResetEvent(String eventCode) {
    return resetEventCodes().contains(eventCode);
  }

  public List<String> resetEventCodes() {
    List<String> result = new ArrayList<>();
    for (Event e: resetEvents) result.add(e.getCode());
    return result;
  }

  public State getStart() {
    return start;
  }

  public Notification probeEquivalence(StateMachine other) {
    Notification result = new Notification();
    probeEquivalence(other, result);
    return result;
  }

  private void probeEquivalence(StateMachine other, Notification note) {
    for (State s: getStates()) {
      State otherState = other.getSate(s.getName());
      if (null == otherState) note.error("missing state: %s", s.getName());
      else s.probeEquivalence(otherState, note);
    }
    for (State s: other.getStates()) {
      if (null == getState(s.getName())) note.error("extra state: %s", s.getName());
    }
    for (Event e: getResetEvents()) {
      if (!other.getResetEvents().contains(e)) {
        note.error("missing reset events: %s", e.getName());
      }
    }
    for (Event e: other.getResetEvents()) {
      if (!getResetEvents().contains(e))
        note.error("extra reset event: %s", e.getName());
    }
  }
}
