package com.github.yurysavchuk.records;

import java.util.Objects;

public class PostInfoCl {

  private final Long id;

  private final String title;

  private final AuditInfoCl auditInfo;

  public PostInfoCl(
      Long id,
      String title,
      AuditInfoCl auditInfo
  ) {
    this.id = id;
    this.title = title;
    this.auditInfo = auditInfo;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof PostInfoCl)) return false;
    PostInfoCl postInfo = (PostInfoCl) o;
    return id.equals(postInfo.id) &&
        title.equals(postInfo.title) &&
        auditInfo.equals(postInfo.auditInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id,
        title,
        auditInfo
    );
  }

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
        auditInfo.getCreatedOn(),
        auditInfo.getCreatedBy(),
        auditInfo.getUpdatedOn(),
        auditInfo.getUpdatedBy()
    );
  }
}
