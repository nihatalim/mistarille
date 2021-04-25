package dev.mistarille.infrastructure.user.converter;

import dev.mistarille.domain.user.model.User;
import dev.mistarille.infrastructure.common.converter.BaseConverter;
import dev.mistarille.infrastructure.user.entity.UserCollection;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends BaseConverter<User, UserCollection> {

    @Override
    public UserCollection convert(User collection) {
        UserCollection userCollection = new UserCollection();

        userCollection.setId(collection.getId());
        userCollection.setName(collection.getName());
        userCollection.setEmail(collection.getEmail());
        userCollection.setPassword(collection.getPassword());
        userCollection.setEmailVerified(collection.getEmailVerified());
        userCollection.setLoginAttemptCount(collection.getLoginAttemptCount());
        userCollection.setSignature(collection.getSignature());
        userCollection.setCreatedDate(collection.getCreatedDate());
        userCollection.setUpdatedDate(collection.getUpdatedDate());

        return userCollection;
    }
}
