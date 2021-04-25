package dev.mistarille.infrastructure.user.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Getter
@Setter
public class PasswordResetCollection {
    @Id
    private String id;
    private String userId;
    private String token;
    private Date createdDate;
}
