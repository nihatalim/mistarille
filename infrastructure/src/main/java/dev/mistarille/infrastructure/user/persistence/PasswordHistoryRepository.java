package dev.mistarille.infrastructure.user.persistence;

import dev.mistarille.infrastructure.user.entity.PasswordHistoryCollection;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PasswordHistoryRepository extends MongoRepository<PasswordHistoryCollection, String> {

}
