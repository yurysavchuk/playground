package org.github.yurysauchuk.records;

import static org.junit.Assert.assertEquals;

import com.github.yurysavchuk.records.AuditInfo;
import com.github.yurysavchuk.records.PostInfo;
import java.time.LocalDateTime;
import org.junit.Test;

public class RecordsTest {

  @Test
  public void testRecords() {
    PostInfo postInfo = new PostInfo(
        1L,
        "High-Performance Java Persistence",
        new AuditInfo(
            LocalDateTime.of(2016, 11, 2, 12, 0, 0),
            "Vlad Mihalcea",
            LocalDateTime.now(),
            "Vlad Mihalcea"
        )
    );
    assertEquals(
        1L, postInfo.id().longValue()
    );

    assertEquals(
        "High-Performance Java Persistence", postInfo.title()
    );

    assertEquals(
        LocalDateTime.of(2016, 11, 2, 12, 0, 0), postInfo.auditInfo().createdOn()
    );

    assertEquals(
        "Vlad Mihalcea", postInfo.auditInfo().createdBy()
    );

    System.out.println(String.format("Audit info:\n%s", postInfo.auditInfo()));
    System.out.println(String.format("Post info:\n%s", postInfo));
  }

}
