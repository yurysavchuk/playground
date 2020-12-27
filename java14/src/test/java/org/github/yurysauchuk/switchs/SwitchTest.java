package org.github.yurysauchuk.switchs;


import static org.junit.Assert.assertEquals;

import java.time.DayOfWeek;
import org.junit.Test;

public class SwitchTest {

  @Test
  public void testNewSwitchWithExpression() {
    DayOfWeek day = DayOfWeek.FRIDAY;

    String dayType = switch(day) {
      case MONDAY, THURSDAY, WEDNESDAY, TUESDAY, FRIDAY -> "Weekday";
      case SATURDAY, SUNDAY -> "Weekend";
      default -> throw new IllegalArgumentException("Invalid Day");
    };

    assertEquals("Weekday", dayType);
  }

  @Test
  public void testNewSwitchWithStatement() {
    DayOfWeek day = DayOfWeek.FRIDAY;

    String dayType = switch(day) {
      case MONDAY, THURSDAY, WEDNESDAY, TUESDAY, FRIDAY:
        yield "Weekday";
      case SATURDAY, SUNDAY:
        yield "Weekend";
      default:
        throw new IllegalArgumentException("Invalid Day");
    };

    assertEquals("Weekday", dayType);
  }

}
