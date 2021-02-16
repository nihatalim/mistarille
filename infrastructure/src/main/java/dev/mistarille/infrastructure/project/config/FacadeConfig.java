package dev.mistarille.infrastructure.project.config;

import dev.mistarille.domain.project.ProjectFacade;
import dev.mistarille.domain.project.ProjectPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class FacadeConfig {

    private final ProjectPersistencePort projectPersistencePort;

    @Bean
    public ProjectFacade projectFacade() {
        return new ProjectFacade(projectPersistencePort);
    }
}
