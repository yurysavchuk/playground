package nicebank;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.runtime.java.guice.ScenarioScoped;
import javax.inject.Inject;
import org.junit.Assert;
import support.TestAccount;
import transforms.MoneyConverter;

@ScenarioScoped
public class AccountSteps {
  TestAccount account;

  @Inject
  public AccountSteps(TestAccount account) {
    this.account = account;
  }

  @Given("^my account has been credited with (\\$\\d+\\.\\d+)$")
  public void iHaveDeposited$InMyAccount(
      @Transform(MoneyConverter.class) Money amount
  ) throws Throwable {
    account.credit(amount);
  }

  @Then("^the balance of my account should be (\\$\\d+\\.\\d+)$")
  public void theBalanceOfMyAccountShouldBe$(
      @Transform(MoneyConverter.class) Money amount
  ) throws Throwable {
    int timeoutMilliSec = 3000;
    int pollIntervalMilliSec = 100;

    while (!account.getBalance().equals(amount) && timeoutMilliSec > 0) {
      Thread.sleep(pollIntervalMilliSec);
      timeoutMilliSec -= pollIntervalMilliSec;
    }

    Assert.assertEquals("Incorrect account balance - ",
        amount, account.getBalance());
  }

}
