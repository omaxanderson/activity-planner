package org.activityplanner.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;

    private String username;
    private String password;

    private String firstName, lastName;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.firstName = "";
        this.lastName = "";
    }

    public User(String username, String password, String lastName, String firstName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
