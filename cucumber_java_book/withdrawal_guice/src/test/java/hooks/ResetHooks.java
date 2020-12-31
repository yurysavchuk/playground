package hooks;

import cucumber.api.java.Before;
import cucumber.runtime.java.guice.ScenarioScoped;
import nicebank.Account;
import nicebank.TransactionQueue;
import org.javalite.activejdbc.Base;

@ScenarioScoped
public class ResetHooks {

  @Before(order = 1)
  public void reset() {
    if (!Base.hasConnection()) {
      Base.open(
          "com.mysql.jdbc.Driver",
          "jdbc:mysql://localhost/bank",
          "teller", "password");
    }

    Account.deleteAll();
    TransactionQueue.clear();
  }
}
