package statemachine;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class ModelTest {
  private Event doorClosed, drawerOpened, lightOn, doorOpened, panelClosed;
  private State activeState, waitingForLightState, unlockedPanelState,
                idle, waitingForDrawerState;
  private Command unlockPanelCmd, lockDoorCmd, lockPanelCmd, unlockDoorCmd;
  private CommandChannel channel = new CommandChannel();
  private Controller con;
  private StateMachine machine;

  @BeforeEach
  public void setup() {
    //populate semantic model here
  }
}
