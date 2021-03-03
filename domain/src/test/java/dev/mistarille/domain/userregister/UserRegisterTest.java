package dev.mistarille.domain.userregister;

import dev.mistarille.domain.user.model.User;
import dev.mistarille.domain.user.port.CreateUserPort;
import dev.mistarille.domain.user.usecase.userregister.UserRegistrationUS;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserRegisterTest {

    @Mock
    private CreateUserPort createUserPort;

    @InjectMocks
    private UserRegistrationUS userRegistrationUS;

    @Test
    public void test1() {
        User user = new User();
        user.setUserName("Paul Walker");

        when(createUserPort.createUser(user)).thenReturn(user);

        User registeredUser = userRegistrationUS.apply(user);

        assertEquals(user.getUserName(), registeredUser.getUserName());
    }
}
