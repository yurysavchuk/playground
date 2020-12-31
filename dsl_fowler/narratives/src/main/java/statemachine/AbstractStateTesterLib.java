package statemachine;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractStateTesterLib {

  protected CommandChannel commandChannel = new CommandChannel();
  protected StateMachine machine;
  protected Controller controller;

  public void setup() {
    machine = createMachine();
    controller = new Controller(machine, commandChannel);
  }

  abstract protected StateMachine createMachine();

  protected void fire(Event e) {
    controller.handle(e.getCode());
  }

  protected void assertCurrentState(State s) {
    assertEquals(s, controller.getCurrentState());
  }

}
