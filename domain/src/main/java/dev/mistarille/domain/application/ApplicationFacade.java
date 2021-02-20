package dev.mistarille.domain.application;

import dev.mistarille.domain.application.model.Application;
import dev.mistarille.domain.application.port.ApplicationCreatePort;
import dev.mistarille.domain.application.usecase.ApplicationCreateUS;

public class ApplicationFacade {
    private ApplicationCreateUS applicationCreate;

    public ApplicationFacade(ApplicationCreateUS applicationCreate) {
        this.applicationCreate = applicationCreate;
    }

    public Application createApplication(Application application){
        return applicationCreate.apply(application);
    }
}
