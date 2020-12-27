package com.github.yurysavchuk.records;

public record PostInfo(
    Long id,
    String title,
    AuditInfo auditInfo
) {
  @Override
  public String toString() {
    return String.format("""
            PostInfo {
                id : '%s',
                title : '%s',
                auditInfo : {
                    createdOn : '%s',
                    createdBy : '%s',
                    updatedOn : '%s',
                    updatedBy : '%s'
                }
            }
            """,
        id,
        title,
        auditInfo.createdOn(),
        auditInfo.createdBy(),
        auditInfo.updatedOn(),
        auditInfo.updatedBy()
    );
  }
}
