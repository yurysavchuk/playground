/***
 * Excerpted from "The Cucumber for Java Book",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/srjcuc for more book information.
 ***/
package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.springframework.beans.factory.annotation.Autowired;

import nicebank.Account;
import nicebank.AtmServer;
import nicebank.CashSlot;

public class ServerHooks {

  public static final int PORT = 8887;

  private AtmServer server;

  @Autowired
  private Account account;

  @Autowired
  private CashSlot cashSlot;

  @Before
  public void startServer() throws Exception {
    setFirefoxGeckoDriverPath();

    server = new AtmServer(PORT, cashSlot, account);
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
