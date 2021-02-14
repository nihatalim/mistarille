package dev.mistarille.infrastructure.project.converter.entitymodel;

import dev.mistarille.domain.project.model.Project;
import dev.mistarille.infrastructure.project.persistence.entity.ProjectEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class ProjectConverterTest {

    @InjectMocks
    private ProjectConverter projectConverter;

    @Test
    public void shouldConvertProjectToEntityWithoutAccessKey() {
        String projectName = "Project X";
        UUID projectOwnerId = UUID.randomUUID();

        Project project = Project.createNewProjectWithoutAccessKey(projectName, projectOwnerId);

        ProjectEntity projectEntity = projectConverter.convertToProjectEntity(project);

        assertEquals(projectName, projectEntity.getProjectName());
        assertEquals(projectOwnerId.toString(), projectEntity.getProjectOwnerId());
        assertEquals(project.getProjectId().toString(), projectEntity.getProjectId());
        assertNull(projectEntity.getProjectAccessKey());
    }

    @Test
    public void shouldConvertProjectEntityToProjectWithoutAccessKey() {
        UUID projectId = UUID.randomUUID();
        String projectName = "Project X";
        UUID projectOwnerId = UUID.randomUUID();

        ProjectEntity entity = new ProjectEntity();

        entity.setProjectId(projectId.toString());
        entity.setProjectName(projectName);
        entity.setProjectOwnerId(projectOwnerId.toString());

        Project project = projectConverter.convertToProject(entity);

        assertEquals(projectName, project.getProjectName());
        assertEquals(projectOwnerId, project.getProjectOwnerId());
        assertEquals(projectId, project.getProjectId());
        assertNull(project.getProjectAccessKey());
    }
}
