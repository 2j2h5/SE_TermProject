package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import domain.Issue;

class IssueTest {

    @Test
    void testIssue() {
        Issue issue = new Issue("title123", "description123", "priority123", 123, "reporter123", "reportedDate123", "state123");
        assertEquals(1, issue.getId());
        assertEquals("title123", issue.getTitle());
        assertEquals("description123", issue.getDescription());
        assertEquals("priority123", issue.getPriority());
        assertEquals(123, issue.getProject());
        assertEquals("reporter123", issue.getReporter());
        assertEquals("reportedDate123", issue.getReportedDate());
        assertEquals("state123", issue.getState());
    }

}