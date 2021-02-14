package dev.mistarille.infrastructure.project.persistence;

import dev.mistarille.domain.project.ProjectPersistencePort;
import dev.mistarille.domain.project.model.Project;
import dev.mistarille.infrastructure.project.converter.entitymodel.ProjectConverter;
import dev.mistarille.infrastructure.project.persistence.entity.ProjectEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProjectPersistenceAdapter implements ProjectPersistencePort {

    private final ProjectRepository projectRepository;
    private final ProjectConverter projectConverter;

    @Override
    public boolean isProjectNameAlreadyExist(String projectName) {
        Optional<ProjectEntity> project = projectRepository.findByProjectName(projectName);
        return project.isPresent();
    }

    @Override
    public Project saveNewProject(Project project) {
        ProjectEntity projectEntity = projectConverter.convertToProjectEntity(project);
        ProjectEntity savedEntity = projectRepository.save(projectEntity);
        return projectConverter.convertToProject(savedEntity);
    }
}
