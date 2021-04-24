package dev.mistarille.domain.user.port;

public interface PasswordResetPort {
    void savePasswordHistory(String userId, String password);
}
