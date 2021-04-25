package dev.mistarille.infrastructure.user.adapter;

import dev.mistarille.domain.user.port.PasswordHistoryPort;
import dev.mistarille.infrastructure.user.entity.PasswordHistoryCollection;
import dev.mistarille.infrastructure.user.persistence.PasswordHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PasswordHistoryAdapter implements PasswordHistoryPort {
    private final PasswordHistoryRepository passwordHistoryRepository;

    @Override
    public void saveNewHistory(String userId, String password) {
        PasswordHistoryCollection passwordHistory = new PasswordHistoryCollection();
        passwordHistory.setUserId(userId);
        passwordHistory.setPassword(password);
        passwordHistoryRepository.save(passwordHistory);
    }
}
