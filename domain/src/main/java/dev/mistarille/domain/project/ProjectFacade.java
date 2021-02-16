package dev.mistarille.domain.project;

import dev.mistarille.domain.exception.ExceptionKey;
import dev.mistarille.domain.exception.ModelCreationException;
import dev.mistarille.domain.project.model.Project;

import java.util.UUID;

public class ProjectFacade {

    private final ProjectPersistencePort projectPersistencePort;

    public ProjectFacade(ProjectPersistencePort projectPersistencePort) {
        this.projectPersistencePort = projectPersistencePort;
    }

    public Project saveProject(UUID projectOwnerId, String projectName) {
        Project project = createProjectWithUniqueProjectName(projectOwnerId, projectName);
        return projectPersistencePort.saveNewProject(project);
    }

    private Project createProjectWithUniqueProjectName(UUID projectOwnerId, String projectName) {
        validateProjectName(projectName);
        return Project.createNewProjectWithoutAccessKey(projectName, projectOwnerId);
    }

    private void validateProjectName(String projectName) {
        if (projectPersistencePort.isProjectNameAlreadyExist(projectName)) {
            throw new ModelCreationException(ExceptionKey.PROJECT_NAME_IS_NOT_UNIQUE);
        }
    }
}
