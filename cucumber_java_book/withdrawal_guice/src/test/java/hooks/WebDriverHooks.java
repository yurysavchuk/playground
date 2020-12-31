package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.runtime.java.guice.ScenarioScoped;
import javax.inject.Inject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import support.MyWebDriver;

@ScenarioScoped
public class WebDriverHooks {

  private EventFiringWebDriver driver;

  @Inject
  public WebDriverHooks(MyWebDriver driver) {
    this.driver = driver;
  }

  @After
  public void finish(Scenario scenario) {
    try {
      byte[] screenshot =
          driver.getScreenshotAs(OutputType.BYTES);
      scenario.embed(screenshot, "image/png");
    } catch (WebDriverException somePlatformsDontSupportScreenshots) {
      System.err.println(somePlatformsDontSupportScreenshots.getMessage());
    } finally {
      driver.close();
    }
  }
}
