package dev.mistarille.domain.project;

import dev.mistarille.domain.exception.ExceptionKey;
import dev.mistarille.domain.exception.ModelCreationException;
import dev.mistarille.domain.project.model.Project;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProjectFacadeTest {

    @Mock
    private ProjectPersistencePort projectPersistencePort;

    @InjectMocks
    private ProjectFacade projectFacade;

    @Captor
    private ArgumentCaptor<Project> projectArgumentCaptor;

    @Test
    public void shouldNotSaveProjectWithNotValidProjectName() {
        String projectName = "Project X";
        UUID projectOwnerId = UUID.randomUUID();

        when(projectPersistencePort.isProjectNameAlreadyExist(projectName)).thenReturn(true);

        try {
            projectFacade.saveProject(projectOwnerId, projectName);
        } catch (ModelCreationException e) {
            verify(projectPersistencePort).isProjectNameAlreadyExist(projectName);

            assertEquals(e.getMessage(), ExceptionKey.PROJECT_NAME_IS_NOT_UNIQUE.getMessageKey());
            assertEquals(Project.class.getDeclaredFields().length, 4);
        }
    }

    @Test
    public void shouldSaveNewProjectWithoutAccessKey() {
        String projectName = "Project X";
        UUID projectOwnerId = UUID.randomUUID();

        when(projectPersistencePort.isProjectNameAlreadyExist(projectName)).thenReturn(false);

        projectFacade.saveProject(projectOwnerId, projectName);

        verify(projectPersistencePort).isProjectNameAlreadyExist(projectName);
        verify(projectPersistencePort).saveNewProject(projectArgumentCaptor.capture());

        Project saveProject = projectArgumentCaptor.getValue();

        assertNull(saveProject.getProjectAccessKey());
        assertNotNull(saveProject.getProjectId());
        assertEquals(saveProject.getProjectName(), projectName);
        assertEquals(saveProject.getProjectOwnerId(), projectOwnerId);
        assertEquals(Project.class.getDeclaredFields().length, 4);
    }
}
