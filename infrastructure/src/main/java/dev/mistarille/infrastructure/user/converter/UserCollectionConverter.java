package dev.mistarille.infrastructure.user.converter;

import dev.mistarille.domain.user.model.User;
import dev.mistarille.infrastructure.common.converter.BaseConverter;
import dev.mistarille.infrastructure.user.entity.UserCollection;
import org.springframework.stereotype.Component;

@Component
public class UserCollectionConverter extends BaseConverter<UserCollection, User> {

    @Override
    public User convert(UserCollection userCollection) {
        User user = new User();

        user.setId(userCollection.getId());
        user.setName(userCollection.getName());
        user.setEmail(userCollection.getEmail());
        user.setPassword(userCollection.getPassword());
        user.setEmailVerified(userCollection.getEmailVerified());
        user.setLoginAttemptCount(userCollection.getLoginAttemptCount());
        user.setSignature(userCollection.getSignature());
        user.setCreatedDate(userCollection.getCreatedDate());
        user.setUpdatedDate(userCollection.getUpdatedDate());

        return user;
    }
}
