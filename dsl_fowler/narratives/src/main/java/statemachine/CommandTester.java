package statemachine;

public class CommandTester {
  Command commenceEarthquake = new Command("Commence Earthquake", "EQST");
  State idle = new State("idle");
  State second = new State("second");
  Event trigger = new Event("trigger", "TGGR");

  protected StateMachine createMachine() {
    second.addAction(commenceEarthquake);
    idle.addTransition(trigger, second);
    return new StateMachine(idle);
  }
}
