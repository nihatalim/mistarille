package dev.mistarille.infrastructure.user.persistence;

import dev.mistarille.infrastructure.user.entity.UserCollection;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserCollection, String> {
    boolean existsUserCollectionByEmail(String email);
}
