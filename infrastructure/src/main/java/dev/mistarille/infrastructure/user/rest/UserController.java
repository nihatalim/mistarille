package dev.mistarille.infrastructure.user.rest;

import dev.mistarille.domain.user.UserFacade;
import dev.mistarille.domain.user.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserFacade userFacade;

    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @PostMapping("create")
    public User createUser(@RequestBody User user) {
        return this.userFacade.userRegister(user);
    }
}
