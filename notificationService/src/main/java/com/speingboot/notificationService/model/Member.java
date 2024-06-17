package com.speingboot.notificationService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "members")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    private UUID id = UUID.randomUUID();
    private String firstName;
    private String lastName;
    private String email;
}
