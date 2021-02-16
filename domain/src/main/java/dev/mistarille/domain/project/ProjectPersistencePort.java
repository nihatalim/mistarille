package dev.mistarille.domain.project;

import dev.mistarille.domain.project.model.Project;

public interface ProjectPersistencePort {
    boolean isProjectNameAlreadyExist(String projectName);

    Project saveNewProject(Project project);

    String getProjectIdByAccessToken(String accessToken);
}