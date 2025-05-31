package com.northcoders.eventapp.model;



public class Staff {
    String first_name;
    String last_name;
    String birth_date;
    String emailAddress;
    String username;
    String password;
    String role;

    public Staff(String first_name, String last_name, String birth_date, String emailAddress, String username, String password, String role) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.emailAddress = emailAddress;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Staff() {
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
