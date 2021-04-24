package dev.mistarille.domain.common.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.SecureRandom;

public class SignatureUtil {

    public static String generateRandomSignatureBySha256ToHex() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bytes = secureRandom.generateSeed(256);
        return DigestUtils.sha256Hex(bytes);
    }
}
