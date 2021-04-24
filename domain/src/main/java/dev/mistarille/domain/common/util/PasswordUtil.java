package dev.mistarille.domain.common.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.generators.BCrypt;
import org.bouncycastle.util.encoders.Hex;

import java.nio.charset.StandardCharsets;

public class PasswordUtil {
    public static String generatePasswordWithBCryptAlgorithm(String password, String salt) {
        byte[] saltBytes = md5(salt);
        byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);

        return Hex.toHexString(BCrypt.generate(passwordBytes, saltBytes, 4));
    }

    private static byte[] md5(String value) {
        return DigestUtils.md5(value.getBytes(StandardCharsets.UTF_8));
    }
}
