package com.unibuc.javaproject.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

public class UserRequest {
    @NotNull
    @NotBlank(message = "Username cannot be null.")
    private String username;
    @NotNull
    @NotBlank(message = "Password cannot be null.")
    private String password;
    @NotNull
    @NotBlank(message = "Email cannot be null.")
    @Email(message = "Email must have a standard email format.")
    //de testat
    private String email;

    public UserRequest() {
    }

    public UserRequest(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
