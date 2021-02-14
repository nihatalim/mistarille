package dev.mistarille.infrastructure.project.converter.entitymodel;

import dev.mistarille.domain.project.model.Project;
import dev.mistarille.infrastructure.project.persistence.entity.ProjectEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProjectConverter {

    public ProjectEntity convertToProjectEntity(Project project) {
        ProjectEntity entity = new ProjectEntity();

        entity.setProjectId(project.getProjectId().toString());
        entity.setProjectOwnerId(project.getProjectOwnerId().toString());
        entity.setProjectName(project.getProjectName());
        entity.setProjectAccessKey(project.getProjectAccessKey());

        return entity;
    }

    public Project convertToProject(ProjectEntity entity) {
        Project project = Project.createNewProjectWithoutAccessKey(
                entity.getProjectName(),
                UUID.fromString(entity.getProjectOwnerId())
        );

        project.setProjectId(UUID.fromString(entity.getProjectId()));

        project.setProjectAccessKey(entity.getProjectAccessKey());

        return project;
    }
}
