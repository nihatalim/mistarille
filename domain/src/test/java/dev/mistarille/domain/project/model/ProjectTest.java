package dev.mistarille.domain.project.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class ProjectTest {

    @Test
    public void shouldCreateProjectWithoutAccessKey() {
        String projectName = "Project X";
        UUID projectOwnerId = UUID.randomUUID();

        Project project = Project.createNewProjectWithoutAccessKey(projectName, projectOwnerId);

        assertNotNull(project.getProjectId());
        assertTrue(project.getProjectId() instanceof UUID);
        assertNull(project.getProjectAccessKey());
        assertEquals(project.getProjectName(), projectName);
        assertEquals(project.getProjectOwnerId(), projectOwnerId);
        assertTrue(project.getProjectOwnerId() instanceof UUID);
    }
}
