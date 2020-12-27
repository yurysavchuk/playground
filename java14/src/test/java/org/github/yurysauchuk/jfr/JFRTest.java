package org.github.yurysauchuk.jfr;

import java.time.Duration;
import jdk.jfr.Configuration;
import jdk.jfr.consumer.RecordingStream;
import org.junit.Ignore;
import org.junit.Test;

public class JFRTest {

  @Test
  @Ignore
  public void testJFRConfiguration() throws Exception {
    Configuration config = Configuration.getConfiguration("default");
    try (var es = new RecordingStream(config)) {
      es.onEvent("jdk.GarbageCollection", System.out::println);
      es.onEvent("jdk.CPULoad", System.out::println);
      es.onEvent("jdk.JVMInformation", System.out::println);
      es.setMaxAge(Duration.ofSeconds(10));
      es.start();
    }

  }

}
