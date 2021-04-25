package dev.mistarille.infrastructure.user.adapter;

import dev.mistarille.domain.user.model.User;
import dev.mistarille.domain.user.port.TokenPort;
import dev.mistarille.domain.user.port.UserPort;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TokenAdapter implements TokenPort {
    private final UserPort userPort;

    @Override
    public String generateToken(String userId) {
        Optional<User> optionalUser = userPort.findById(userId);

        User user = optionalUser.orElseThrow(() -> new RuntimeException("user not found"));

        Key key = Keys.hmacShaKeyFor(user.getSignature().getBytes());

        return Jwts.builder().setSubject(userId).signWith(key).compact();
    }
}
