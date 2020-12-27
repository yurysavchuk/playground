package com.github.yurysavchuk.records;

import java.time.LocalDateTime;
import java.util.Objects;

public class AuditInfoCl {

  private final LocalDateTime createdOn;

  private final String createdBy;

  private final LocalDateTime updatedOn;

  private final String updatedBy;

  public AuditInfoCl(
      LocalDateTime createdOn,
      String createdBy,
      LocalDateTime updatedOn,
      String updatedBy) {
    this.createdOn = createdOn;
    this.createdBy = createdBy;
    this.updatedOn = updatedOn;
    this.updatedBy = updatedBy;
  }

  public LocalDateTime getCreatedOn() {
    return createdOn;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public LocalDateTime getUpdatedOn() {
    return updatedOn;
  }

  public String getUpdatedBy() {
    return updatedBy;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuditInfoCl auditInfo = (AuditInfoCl) o;
    return createdOn.equals(auditInfo.createdOn) &&
        createdBy.equals(auditInfo.createdBy) &&
        Objects.equals(updatedOn, auditInfo.updatedOn) &&
        Objects.equals(updatedBy, auditInfo.updatedBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdOn, createdBy, updatedOn, updatedBy);
  }

  @Override
  public String toString() {
    return String.format("""
        AuditInfo {
          createdOn: '%s',
          createdBy: '%s',
          updatedOn: '%s',
          updatedBy: '%s',
        }
        """,
        createdOn,
        createdBy,
        updatedOn,
        updatedBy
    );
  }
}
