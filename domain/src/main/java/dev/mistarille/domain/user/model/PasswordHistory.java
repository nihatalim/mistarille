package dev.mistarille.domain.user.model;

import lombok.Data;
import org.joda.time.DateTime;

@Data
public class PasswordHistory {
    private String id;
    private String userId;
    private String password;
    private DateTime createdDate;
}
