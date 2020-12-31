package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import nicebank.AmtServer;
import nicebank.CashSlot;
import support.TestAccount;

public class ServerHooks {
  public static final int PORT = 8887;

  private AmtServer server;
  private CashSlot cashSlot;
  private TestAccount account;

public ServerHooks(
    CashSlot cashSlot,
    TestAccount account
) {
  this.cashSlot = cashSlot;
  this.account = account;
}

  @Before
  public void startServer() throws Exception {
    setFirefoxGeckoDriverPath();

    server = new AmtServer(PORT, cashSlot, account);
    server.start();
  }

  private void setFirefoxGeckoDriverPath() {
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    String geckoDriverPath = classloader.getResource("driver/geckodriver.exe").getPath();
    System.setProperty("webdriver.gecko.driver", geckoDriverPath);
  }

  @After
  public void stopServer() throws Exception {
    server.stop();
  }

}
