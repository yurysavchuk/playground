package com.github.yurysavchuk.dependencynetwork;

import java.time.LocalDateTime;

public class MacGuffinProfile {

  private LocalDateTime timestamp;

  public MacGuffinProfile(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

}
