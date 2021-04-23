package dev.mistarille.infrastructure.user.configuration;

import dev.mistarille.domain.user.UserFacade;
import dev.mistarille.domain.user.port.CreateUserPort;
import dev.mistarille.domain.user.usecase.userregister.UserRegistrationUS;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    private final CreateUserPort createUserPort;

    public UserConfiguration(CreateUserPort createUserPort) {
        this.createUserPort = createUserPort;
    }

    @Bean
    public UserFacade userFacade() {
        UserRegistrationUS userRegistrationUS = new UserRegistrationUS(createUserPort);
        return new UserFacade(userRegistrationUS);
    }
}
