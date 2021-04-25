package dev.mistarille.domain.user.port;

import dev.mistarille.domain.user.model.User;

import java.util.Optional;

public interface UserPort {
    Boolean isEmailAlreadyUsing(String email);

    User saveNewUser(User user);

    Optional<User> findById(String userId);
}
