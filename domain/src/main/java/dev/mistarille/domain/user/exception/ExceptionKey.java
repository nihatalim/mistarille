package dev.mistarille.domain.user.exception;

public enum ExceptionKey {
    ;

    private String messageKey;

    ExceptionKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public String getMessageKey() {
        return messageKey;
    }
}
