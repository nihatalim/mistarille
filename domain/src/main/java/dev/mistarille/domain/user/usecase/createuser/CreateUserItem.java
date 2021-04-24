package dev.mistarille.domain.user.usecase.createuser;

import lombok.Value;

@Value
public class CreateUserItem {
    String email;
    String password;
}
