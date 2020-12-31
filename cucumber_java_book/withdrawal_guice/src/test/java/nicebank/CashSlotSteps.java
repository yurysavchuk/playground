package nicebank;

import cucumber.api.java.en.Then;
import cucumber.runtime.java.guice.ScenarioScoped;
import javax.inject.Inject;
import org.junit.Assert;
import support.TestCashSlot;

@ScenarioScoped
public class CashSlotSteps {

  CashSlot cashSlot;

  @Inject
  public CashSlotSteps(TestCashSlot cashSlot) {
    this.cashSlot = cashSlot;
  }

  @Then("^\\$(\\d+) should be dispensed$")
  public void $ShouldBeDispensed(int dollars) throws Throwable {
    Assert.assertEquals("Incorrect amount dispensed - ",
        dollars, cashSlot.getContents());
  }
}
