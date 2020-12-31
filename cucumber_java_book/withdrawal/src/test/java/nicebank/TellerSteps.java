package nicebank;

import cucumber.api.java.en.When;
import support.AtmUserInterface;
import support.TestAccount;

public class TellerSteps {

  Teller teller;
  TestAccount account;

  public TellerSteps(AtmUserInterface teller, TestAccount account) {
    this.teller = teller;
    this.account = account;
  }

  @When("^I withdraw \\$(\\d+)$")
  public void iRequest$(int dollars) throws Throwable {
    teller.withdrawFrom(account, dollars);
  }
}
