package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domain.Comment;

public class CommentTest {
	@Test
    void testProject() {
        Comment comment = new Comment("content123", "writer123", "writedDate123", 123);
        assertEquals(1, comment.getId());
        assertEquals("content123", comment.getContent());
        assertEquals("writer123", comment.getWriter());
        assertEquals("writedDate123", comment.getWritedDate());
        assertEquals(123, comment.getIssue());
    }
}
