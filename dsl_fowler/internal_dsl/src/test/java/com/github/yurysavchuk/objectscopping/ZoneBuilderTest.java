package com.github.yurysavchuk.objectscopping;

import static com.github.yurysavchuk.objectscopping.Department.AUDIT;
import static com.github.yurysavchuk.objectscopping.Department.FINANCE;
import static com.github.yurysavchuk.objectscopping.Department.K9;
import static com.github.yurysavchuk.objectscopping.Department.MF;
import static com.github.yurysavchuk.objectscopping.Grade.DIRECTOR;

import org.junit.Test;

public class ZoneBuilderTest {

  @Test
  public void testZoneBuilder() {
    // given
    ZoneBuilder builder = new ZoneBuilder() {{
      allow(department(MF));
      refuse(department(FINANCE));
      refuse(department(AUDIT));
      allow(
        gradeAtLeast(DIRECTOR),
        department(K9));
    }};

    // when
    Zone zone = builder.getValue();

  }

}
