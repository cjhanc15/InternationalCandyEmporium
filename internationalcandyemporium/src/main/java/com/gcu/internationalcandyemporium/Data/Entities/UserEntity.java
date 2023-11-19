package com.gcu.internationalcandyemporium.Data.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Table("USERS")
public class UserEntity {

    @Id
    private Long id;

    @Column("FIRST_NAME")
    @NotBlank(message = "First Name is required")
    private String firstName;

    @Column("LAST_NAME")
    @NotBlank(message = "Last Name is required")
    private String lastName;

    @Column("EMAIL_ADDRESS")
    @NotBlank(message = "Email Address is required")
    @Email(message = "Invalid email format")
    private String emailAddress;

    @Column("PHONE_NUMBER")
    private String phoneNumber;

    @Column("USERNAME")
    private String username;

    @Column("PASSWORD")
    private String password;
}
