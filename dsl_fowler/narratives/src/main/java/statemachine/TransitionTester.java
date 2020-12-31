package statemachine;

import org.junit.jupiter.api.Test;

public class TransitionTester extends AbstractStateTesterLib {

  State idle, a, b;
  Event trigger_a, trigger_b, unknown;

  @Test
  public void event_causes_transition() {
    fire(trigger_a);
    assertCurrentState(a);
  }

  @Test
  public void event_without_transition_is_ignored() {
    fire(unknown);
    assertCurrentState(idle);
  }

  protected StateMachine createMachine() {
    idle = new State("idle");
    StateMachine result = new StateMachine(idle);
    trigger_a = new Event("trigger_a", "TRGA");
    trigger_b = new Event("trigger_b", "TRGB");
    unknown = new Event("Unknown", "UNKN");
    a = new State("a");
    b = new State("b");
    idle.addTransition(trigger_a, a);
    idle.addTransition(trigger_b, b);
    return result;
  }
}
