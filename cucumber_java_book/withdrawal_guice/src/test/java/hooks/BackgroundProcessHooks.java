package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.runtime.java.guice.ScenarioScoped;
import nicebank.TransactionProcessor;

@ScenarioScoped
public class BackgroundProcessHooks {

  private Thread transactionProcessorThread;

  @Before
  public void startBackgroundThread() {
    transactionProcessorThread = new Thread(() -> {
      TransactionProcessor processor = new TransactionProcessor();
      processor.process();
    });

    transactionProcessorThread.start();
  }

  @After
  public void stopBackgroundThread() {
    transactionProcessorThread.interrupt();
  }

}
