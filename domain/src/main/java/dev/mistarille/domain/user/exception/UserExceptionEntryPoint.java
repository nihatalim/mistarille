package dev.mistarille.domain.user.exception;

public class UserExceptionEntryPoint {
    public static void throwError(ExceptionKey exceptionKey) {
        throw new RuntimeException(exceptionKey.getMessageKey());
    }
}
