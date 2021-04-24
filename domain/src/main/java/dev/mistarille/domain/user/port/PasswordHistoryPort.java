package dev.mistarille.domain.user.port;

public interface PasswordHistoryPort {
    void saveNewHistory(String userId, String password);
}
