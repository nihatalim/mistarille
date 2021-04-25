package dev.mistarille.infrastructure.user.adapter;

import dev.mistarille.domain.user.model.User;
import dev.mistarille.domain.user.port.UserPort;
import dev.mistarille.infrastructure.user.converter.UserCollectionConverter;
import dev.mistarille.infrastructure.user.converter.UserConverter;
import dev.mistarille.infrastructure.user.entity.UserCollection;
import dev.mistarille.infrastructure.user.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAdapter implements UserPort {
    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final UserCollectionConverter userCollectionConverter;

    @Override
    public Boolean isEmailAlreadyUsing(String email) {
        return userRepository.existsUserCollectionByEmail(email);
    }

    @Override
    public User saveNewUser(User user) {
        UserCollection userCollection = userConverter.convert(user);
        userCollection = userRepository.save(userCollection);
        return userCollectionConverter.convert(userCollection);
    }

    @Override
    public Optional<User> findById(String userId) {
        Optional<UserCollection> collectionUser = userRepository.findById(userId);
        return collectionUser.map(userCollectionConverter::convert);
    }
}
