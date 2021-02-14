package dev.mistarille.domain.project.model;

import java.util.UUID;

public class Project {
    private UUID projectId;
    private String projectName;
    private UUID projectOwnerId;
    private String projectAccessKey;

    private Project() {
    }

    public static Project createNewProjectWithoutAccessKey(String projectName, UUID projectOwnerId) {
        Project project = new Project();

        project.setProjectId(UUID.randomUUID());
        project.setProjectName(projectName);
        project.setProjectOwnerId(projectOwnerId);

        return project;
    }

    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public UUID getProjectOwnerId() {
        return projectOwnerId;
    }

    public void setProjectOwnerId(UUID projectOwnerId) {
        this.projectOwnerId = projectOwnerId;
    }

    public String getProjectAccessKey() {
        return projectAccessKey;
    }

    public void setProjectAccessKey(String projectAccessKey) {
        this.projectAccessKey = projectAccessKey;
    }
}
