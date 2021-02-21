package dev.mistarille.domain.user.usecase;

import dev.mistarille.domain.common.usecase.FunctionUseCase;
import dev.mistarille.domain.user.model.User;
import dev.mistarille.domain.user.port.CreateUserPort;

public class UserRegistrationUS extends FunctionUseCase<User, User> {

    private final CreateUserPort createUserPort;

    public UserRegistrationUS(CreateUserPort createUserPort) {
        this.createUserPort = createUserPort;
    }

    @Override
    protected User run(User user) {
        return null;
    }

    @Override
    protected void validate(User user) {

    }
}
