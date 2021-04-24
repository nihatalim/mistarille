package dev.mistarille.domain.user.port;

public interface TokenPort {
    String generateToken(String userId);
}
