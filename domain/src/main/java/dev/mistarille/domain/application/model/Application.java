package dev.mistarille.domain.application.model;

import java.util.UUID;

public class Application {
    private UUID applicationId;
    private UUID projectId;

    private String applicationName;
    private String applicationAccessToken;

    public UUID getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(UUID applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    public String getApplicationAccessToken() {
        return applicationAccessToken;
    }

    public void setApplicationAccessToken(String applicationAccessToken) {
        this.applicationAccessToken = applicationAccessToken;
    }
}
