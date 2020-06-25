package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by A.A.MAMUN on 6/25/2020.
 */
@Entity
@Table(name = "app_user")
public class AppUser {

    @Id
    @Email(message = "Please enter valid email address")
    private String email;

    @Size(min = 8, message = "Password length must be at least 8 character")
    private String password;

    public AppUser() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
