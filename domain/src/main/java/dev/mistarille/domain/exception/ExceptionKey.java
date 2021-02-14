package dev.mistarille.domain.exception;

public enum ExceptionKey {
    PROJECT_NAME_IS_NOT_UNIQUE("");

    private String messageKey;

    ExceptionKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public String getMessageKey() {
        return messageKey;
    }
}
