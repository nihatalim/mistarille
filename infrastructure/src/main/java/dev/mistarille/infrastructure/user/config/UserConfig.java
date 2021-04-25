package dev.mistarille.infrastructure.user.config;

import dev.mistarille.domain.user.port.PasswordHistoryPort;
import dev.mistarille.domain.user.port.TokenPort;
import dev.mistarille.domain.user.port.UserPort;
import dev.mistarille.domain.user.usecase.createuser.CreateUserUS;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UserConfig {
    private final UserPort userPort;
    private final PasswordHistoryPort passwordHistoryPort;
    private final TokenPort tokenPort;

    @Bean
    public CreateUserUS createUserUS() {
        return new CreateUserUS(userPort, passwordHistoryPort, tokenPort);
    }
}
