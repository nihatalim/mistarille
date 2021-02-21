package dev.mistarille.domain.user.validation;

import dev.mistarille.domain.common.validation.Validation;

import java.util.regex.Pattern;

public class UserValidation extends Validation {

    public void validateUserId(String userId) {
        checkValueIsNotNull(userId);
    }

    public UserValidation validateUserName(String userName) {
        String regex = "^(?!.*\\.\\.)(?!.*\\.$)[^\\W][\\w.]{0,29}$";

        checkValueIsNotEmpty(userName);

        if (!Pattern.matches(regex, userName)) {
        }

        return this;
    }
}
