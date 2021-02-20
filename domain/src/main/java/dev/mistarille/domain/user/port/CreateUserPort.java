package dev.mistarille.domain.user.port;

import dev.mistarille.domain.user.model.User;

public interface CreateUserPort {
    User createUser(User user);
}
