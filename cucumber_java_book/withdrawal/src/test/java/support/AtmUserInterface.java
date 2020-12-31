package support;

import hooks.ServerHooks;
import nicebank.Account;
import nicebank.Teller;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class AtmUserInterface implements Teller {

  private final EventFiringWebDriver webDriver;

  public AtmUserInterface(MyWebDriver webDriver){
    this.webDriver = webDriver;
  }

  @Override
  public void withdrawFrom(Account account, int dollars) {
    webDriver.get("http://localhost:" + ServerHooks.PORT);
    webDriver.findElement(By.id("amount"))
        .sendKeys(String.valueOf(dollars));
    webDriver.findElement(By.id("withdraw")).click();
  }

}
