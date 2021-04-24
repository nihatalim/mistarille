package dev.mistarille.domain.user.port;

import dev.mistarille.domain.user.model.User;

public interface UserPort {
    Boolean isEmailAlreadyUsing(String email);

    User saveNewUser(User user);
}
