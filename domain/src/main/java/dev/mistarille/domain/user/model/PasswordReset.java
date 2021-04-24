package dev.mistarille.domain.user.model;

import lombok.Data;

import java.util.Date;

@Data
public class PasswordReset {
    private String id;
    private String userId;
    private String token;
    private Date createdDate;
}
