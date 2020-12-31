package com.foo.mavenproject;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;

public class MavenProjectApplicationUnitTest {

  @Test
  public void contextLoads() {
    PersonFetcher personFetcher = new PersonFetcher();

    String print = new PersonPrinter(personFetcher).print();

    BDDAssertions.then(print).isEqualTo("marcin\njohn");
  }

}
