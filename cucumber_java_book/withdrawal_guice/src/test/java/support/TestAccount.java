package support;

import cucumber.runtime.java.guice.ScenarioScoped;
import nicebank.Account;

@ScenarioScoped
public class TestAccount extends Account {

  public TestAccount() {
    super(1234);
    saveIt();
  }

}
