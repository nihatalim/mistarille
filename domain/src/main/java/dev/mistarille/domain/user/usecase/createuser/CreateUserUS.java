package dev.mistarille.domain.user.usecase.createuser;

import dev.mistarille.domain.common.usecase.FunctionUseCase;
import dev.mistarille.domain.common.util.PasswordUtil;
import dev.mistarille.domain.common.util.SignatureUtil;
import dev.mistarille.domain.user.model.User;
import dev.mistarille.domain.user.port.PasswordHistoryPort;
import dev.mistarille.domain.user.port.TokenPort;
import dev.mistarille.domain.user.port.UserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateUserUS extends FunctionUseCase<CreateUserItem, String> {

    private final UserPort userPort;
    private final PasswordHistoryPort passwordHistoryPort;
    private final TokenPort tokenPort;

    private static final Byte LOGIN_ATTEMPT_COUNT = 3;

    @Override
    protected String run(CreateUserItem createUserItem) {
        User newUser = saveNewUser(createUserItem);

        passwordHistoryPort.saveNewHistory(newUser.getId(), newUser.getPassword());

        return tokenPort.generateToken(newUser.getId());
    }

    @Override
    protected void validate(CreateUserItem createUserItem) {
        String email = createUserItem.getEmail();

        if (userPort.isEmailAlreadyUsing(email)) {
            throw new RuntimeException("ex");
        }
    }

    private User saveNewUser(CreateUserItem createUserItem) {
        User newUser = createNewUser(createUserItem);
        return userPort.saveNewUser(newUser);
    }

    private User createNewUser(CreateUserItem createUserItem) {
        String email = createUserItem.getEmail();
        String hashedPassword = getHashedPassword(createUserItem.getPassword(), email);
        String signature = SignatureUtil.generateRandomSignatureBySha256ToHex();

        return new User(email, hashedPassword, signature, LOGIN_ATTEMPT_COUNT);
    }

    private String getHashedPassword(String password, String salt) {
        return PasswordUtil.generatePasswordWithBCryptAlgorithm(password, salt);
    }
}
