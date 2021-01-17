package com.github.yurysavchuk.dependencynetwork;

import java.time.LocalDateTime;

public class Recipe {

  private LocalDateTime timestamp;

  public Recipe(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }
}
