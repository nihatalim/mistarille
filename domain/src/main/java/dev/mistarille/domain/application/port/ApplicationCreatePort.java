package dev.mistarille.domain.application.port;

import dev.mistarille.domain.application.model.Application;

public interface ApplicationCreatePort {
    Application saveNewApplication(Application application);
}
