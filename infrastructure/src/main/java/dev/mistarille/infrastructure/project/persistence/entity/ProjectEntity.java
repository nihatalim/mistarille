package dev.mistarille.infrastructure.project.persistence.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class ProjectEntity {
    @Id
    private String projectId;

    private String projectName;

    private String projectOwnerId;

    private String projectAccessKey;
}
