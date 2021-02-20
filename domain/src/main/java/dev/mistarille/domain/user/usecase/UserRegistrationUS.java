package dev.mistarille.domain.user.usecase;

import dev.mistarille.domain.common.usecase.UseCase;
import dev.mistarille.domain.user.model.User;
import dev.mistarille.domain.user.port.CreateUserPort;

public class UserRegistrationUS implements UseCase<User, User> {

    private final CreateUserPort createUserPort;

    public UserRegistrationUS(CreateUserPort createUserPort) {
        this.createUserPort = createUserPort;
    }

    @Override
    public User apply(User user) {
        return null;
    }
}
