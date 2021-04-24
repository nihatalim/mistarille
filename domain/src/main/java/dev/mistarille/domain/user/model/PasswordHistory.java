package dev.mistarille.domain.user.model;

import lombok.Data;

import java.util.Date;

@Data
public class PasswordHistory {
    private String id;
    private String userId;
    private String password;
    private Date createdDate;
}
