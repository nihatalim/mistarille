package dev.mistarille.infrastructure.user.entity;

import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Getter
@Setter
public class UserCollection {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private Boolean emailVerified;
    private Byte loginAttemptCount;
    private String signature;
    private DateTime createdDate;
    private DateTime updatedDate;

    public UserCollection() {
        this.createdDate = DateTime.now(DateTimeZone.UTC);
        this.updatedDate = DateTime.now(DateTimeZone.UTC);
    }
}
