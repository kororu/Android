package com.example.joseg.loginusuario;

import java.io.Serializable;

public class User implements Serializable {

    String firstname,lastname,user,password;

    public User(String firstname, String lastname, String user, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.user = user;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String fullName() {
        return firstname + " " + lastname;
    }
}
