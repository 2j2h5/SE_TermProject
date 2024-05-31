package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domain.Project;

public class ProjectTest {
		@Test
	    void testProject() {
	        Project project = new Project("name123", "description123", "PL123");
	        assertEquals(1, project.getId());
	        assertEquals("name123", project.getName());
	        assertEquals("description123", project.getDescription());
	        assertEquals("PL123", project.getResponsiblePL());
	        assertEquals("1. name123", project.toString());
	    }
}
