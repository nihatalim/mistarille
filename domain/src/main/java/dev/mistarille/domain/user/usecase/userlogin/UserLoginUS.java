package dev.mistarille.domain.user.usecase.userlogin;

import dev.mistarille.domain.common.usecase.FunctionUseCase;
import dev.mistarille.domain.user.validation.UserValidation;

public class UserLoginUS extends FunctionUseCase<UserLoginItem, String> {

    private final UserValidation userValidation;

    public UserLoginUS(UserValidation userValidation) {
        this.userValidation = userValidation;
    }

    @Override
    protected String run(UserLoginItem userLoginItem) {
        return null;
    }

    @Override
    protected void validate(UserLoginItem userLoginItem) {
        userValidation.validateUserName(userLoginItem.getUserName())
                .elseThrow(new RuntimeException("sdsad"));
    }
}
