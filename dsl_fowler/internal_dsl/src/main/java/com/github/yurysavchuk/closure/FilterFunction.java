package com.github.yurysavchuk.closure;

public interface FilterFunction<T> {
  Boolean passes(T arg);
}
