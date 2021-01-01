package com.github.yurysavchuk.closure;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class MyListTest {

  @Test
  public void testClosure() {
    // given
    List<Employee> employeeList = new ArrayList<>() {{
      add(new Employee(1));
      add(new Employee(4));
    }};
    int threshold = 2;

    // when
    List<Employee> heavyTravelers =
      new MyList<>(employeeList)
        .select(new HeavyTravelerPredicate(threshold));

    // then
    assertEquals(1, heavyTravelers.size());
  }

}
