package com.group15.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.group15.core.BaseEntityModel;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
public class User extends BaseEntityModel{

    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    @NotNull(message = "First Name needed")
    private String firstName;
    @NotNull(message = "last name needed")
    private String lastName;
    @NotNull
    private String username;
    @NotNull
    private String email;

    private int userPoints = 0;
    // json ignore means this will never be exposed to the web via teh api
    @NotNull
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String roles;

    protected User(){
        super();
    }

    public User(String firstName, String lastName, String username, String email, String password, String roles) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        setPassword(password);
        this.roles = roles;
    }

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public int getUserPoints() {
        return userPoints;
    }

    public void setUserPoints(int userPoints) {
        this.userPoints = userPoints;
    }
}
