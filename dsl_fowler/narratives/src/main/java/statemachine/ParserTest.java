package statemachine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ParserTest {

  @Test
  public void loads_states_with_transition() {
    String code =
      "events trigger TGGR end " +
        "state idle " +
        "trigger => target " +
        "end " +
        "state target end ";
    StateMachine actual = StateMachineLoader.loadString(code);

    State idle = actual.getState("idle");
    State target = actual.getState("target");
    assertTrue(idle.hasTransition("TGGR"));
    assertEquals(idle.targetState("TGGR"), target);
  }

  @Test
  public void loads_states_with_transition_using_compare() {
    String code =
      "events trigger TGGR end " +
        "state idle " +
        "trigger => target " +
        "end " +
        "state target end ";
    StateMachine actual = StateMachineLoader.loadString(code);

    State idle = new State("idle");
    State target = new State("target");
    Event trigger = new Event("trigger", "TGGR");
    idle.addTransition(trigger, target);
    StateMachine expected = new StateMachine(idle);

    assertEquivalentMachines(expected, actual);
  }

  private void assertEquivalentMachines(StateMachine left, StateMachine right) {
    assertNotificationOk(left.probeEquivalence(right));
    assertNotificationOk(right.probeEquivalence(left));
  }

  private void assertNotificationOk(Notification n) {
    assertTrue(n.report(), n.isOk());
  }

}
