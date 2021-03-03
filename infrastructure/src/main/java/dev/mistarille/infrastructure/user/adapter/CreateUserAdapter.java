package dev.mistarille.infrastructure.user.adapter;

import dev.mistarille.domain.user.model.User;
import dev.mistarille.domain.user.port.CreateUserPort;
import org.springframework.stereotype.Component;

@Component
public class CreateUserAdapter implements CreateUserPort {
    @Override
    public User createUser(User user) {
        User dummyUser = new User();
        dummyUser.setUserName("Nihat");
        dummyUser.setPassword("123");
        dummyUser.setUserId("1");
        dummyUser.setProjectId("2");
        return dummyUser;
    }
}
