package com.github.yurysavchuk.records;

import java.time.LocalDateTime;

public record AuditInfo(
    LocalDateTime createdOn,
    String createdBy,
    LocalDateTime updatedOn,
    String updatedBy
) {
  @Override
  public String toString() {
    return String.format("""
            AuditInfo {
                createdOn : '%s',
                createdBy : '%s',
                updatedOn : '%s',
                updatedBy : '%s'
            }
            """,
        createdOn,
        createdBy,
        updatedOn,
        updatedBy
    );
  }
}
