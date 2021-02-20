package dev.mistarille.domain.application.usecase;

import dev.mistarille.domain.application.model.Application;
import dev.mistarille.domain.application.port.ApplicationCreatePort;

import java.util.UUID;
import java.util.function.Function;

public class ApplicationCreateUS implements Function<Application,Application> {
    private final ApplicationCreatePort applicationCreatePort;

    public ApplicationCreateUS(ApplicationCreatePort applicationCreatePort) {
        this.applicationCreatePort = applicationCreatePort;
    }

    @Override
    public Application apply(Application application) {

        return null;
    }

    private void validateProject(UUID projectId){

    }
}
