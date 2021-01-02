package com.github.yurysavchuk.nestedclosure;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ScriptTest {

  @Test
  public void scriptTest() {
    // given
    Script script = new Script();

    // when
    script.doBuild();

    // then
    assertEquals(2, script.getResult().getProcessor().getCores());
  }

}
