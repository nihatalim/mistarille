package dev.mistarille.domain.user.model;

import lombok.Data;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

@Data
public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private Boolean emailVerified;
    private Byte loginAttemptCount;
    private String signature;
    private DateTime createdDate;
    private DateTime updatedDate;

    public User(String email, String password, String signature, Byte loginAttemptCount) {
        this.email = email;
        this.password = password;
        this.signature = signature;

        this.name = null;

        this.emailVerified = false;
        this.loginAttemptCount = loginAttemptCount;

        this.signature = signature;

        DateTime now = DateTime.now(DateTimeZone.UTC);

        this.createdDate = now;
        this.updatedDate = now;
    }
}
