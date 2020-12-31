package support;

import com.google.inject.Singleton;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

@Singleton
public class MyWebDriver extends EventFiringWebDriver {

  public MyWebDriver() {
    super(new FirefoxDriver());
  }

}
