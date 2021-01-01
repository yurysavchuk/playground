package com.github.yurysavchuk.closure;

import java.util.ArrayList;
import java.util.List;

public class MyList<T> {

  private List<T> contents;

  public MyList(List<T> contents) {
    this.contents = contents;
  }

  public List<T> select(FilterFunction<T> p) {
    List<T> result = new ArrayList<>();
    for (T candidate : contents) {
      if (p.passes(candidate)) result.add(candidate);
    }
    return result;
  }
}
