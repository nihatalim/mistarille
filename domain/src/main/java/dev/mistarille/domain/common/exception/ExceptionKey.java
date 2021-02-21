package dev.mistarille.domain.common.exception;

public enum ExceptionKey {
    PROPERTY_IS_EMPTY(""),
    PROPERTY_IS_NULL("");

    private String messageKey;

    ExceptionKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public String getMessageKey() {
        return messageKey;
    }
}
