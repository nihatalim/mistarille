package dev.mistarille.domain.userregister;

import dev.mistarille.domain.user.model.User;
import dev.mistarille.domain.user.port.CreateUserPort;
import dev.mistarille.domain.user.usecase.userregister.UserRegistrationUS;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserRegisterTest {

    @Mock
    private CreateUserPort createUserPort;

    @InjectMocks
    private UserRegistrationUS userRegistrationUS;

//    @Test
//    public void test1() {
//        User user = new User();
//        user.setUserName("Paul Walker");
//
//        when(createUserPort.createUser(user)).thenReturn(user);
//
//        User registeredUser = userRegistrationUS.apply(user);
//
//        assertEquals(user.getUserName(), registeredUser.getUserName());
//    }

    @Test
    public void userRegister(){
        solution(new int[]{3,1, -4, 10, -5, 2,4,3});

        User user = this.getMockUser();

        when(createUserPort.createUser(user)).thenReturn(user);

        User apply = userRegistrationUS.apply(user);

        assertEquals(user.getUserName(), apply.getUserName());
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int firstSum = 0;
        int secondSum = Arrays.stream(A).sum();
        int difference = secondSum;

        for(int i = 0; i < A.length; i++){
            firstSum += A[i];
            secondSum -= A[i];

            int diff = Math.abs(firstSum - secondSum);

            if(diff < difference){
                difference = diff;
            }
        }

        return difference;
    }

    private User getMockUser(){
        User user = new User();

        user.setUserName("nihatalim");
        user.setUserId("exampleUserID");
        user.setPassword("2204789");
        user.setAccessToken("TOKEN: 1234567890wertyusdfghj");
        user.setActive(true);

        return user;
    }

}
