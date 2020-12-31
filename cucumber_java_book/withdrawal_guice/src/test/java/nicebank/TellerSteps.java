package nicebank;

import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;
import javax.inject.Inject;
import support.AtmUserInterface;
import support.TestAccount;

@ScenarioScoped
public class TellerSteps {

  Teller teller;
  TestAccount account;

  @Inject
  public TellerSteps(AtmUserInterface teller, TestAccount account) {
    this.teller = teller;
    this.account = account;
  }

  @When("^I withdraw \\$(\\d+)$")
  public void iRequest$(int dollars) throws Throwable {
    teller.withdrawFrom(account, dollars);
  }
}
