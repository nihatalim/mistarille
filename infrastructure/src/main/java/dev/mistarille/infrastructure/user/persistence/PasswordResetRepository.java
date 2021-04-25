package dev.mistarille.infrastructure.user.persistence;

import dev.mistarille.infrastructure.user.entity.PasswordResetCollection;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PasswordResetRepository extends MongoRepository<PasswordResetCollection, String> {
}
