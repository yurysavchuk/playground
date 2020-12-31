package statemachine;

public class Controller {

  private State currentState;
  private StateMachine machine;
  private CommandChannel commandsChannel;

  public Controller(
    StateMachine machine,
    CommandChannel commandsChannel
  ) {
    this.machine = machine;
    this.commandsChannel = commandsChannel;
  }

  public CommandChannel getCommandChannel() {
    return commandsChannel;
  }

  public void handle(String eventCode) {
    if (currentState.hasTransition(eventCode)) {
      transitionTo(currentState.targetState(eventCode));
    } else if (machine.isResetEvent(eventCode)) {
      transitionTo(machine.getStart());
    }
  }

  private void transitionTo(State target) {
    currentState = target;
    currentState.executeActions(commandsChannel);
  }

  public State getCurrentState() {
    return currentState;
  }
}
