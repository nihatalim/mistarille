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
public class PasswordHistoryCollection {
    @Id
    private String id;
    private String userId;
    private String password;
    private Date createdDate;

    public PasswordHistoryCollection() {
        this.createdDate = DateTime.now(DateTimeZone.UTC).toDate();
    }
}
