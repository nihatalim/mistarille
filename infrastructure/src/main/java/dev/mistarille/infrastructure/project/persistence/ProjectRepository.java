package dev.mistarille.infrastructure.project.persistence;

import dev.mistarille.infrastructure.project.persistence.entity.ProjectEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProjectRepository extends MongoRepository<ProjectEntity, String> {
    Optional<ProjectEntity> findByProjectName(String projectName);
}
