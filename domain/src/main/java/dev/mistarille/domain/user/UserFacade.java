package dev.mistarille.domain.user;

import dev.mistarille.domain.user.model.User;
import dev.mistarille.domain.user.usecase.userregister.UserRegistrationUS;

public class UserFacade {
    private final UserRegistrationUS userRegistrationUS;

    public UserFacade(UserRegistrationUS userRegistrationUS) {
        this.userRegistrationUS = userRegistrationUS;
    }

    public User userRegister(User user) {
        return this.userRegistrationUS.apply(user);
    }
}
