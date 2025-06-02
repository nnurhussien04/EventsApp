package com.northcoders.eventapp.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.northcoders.eventapp.BR;

public class Customer extends BaseObservable {
    String first_name;
    String last_name;
    String birth_date;
    String emailAddress;
    String username;
    String password;

    public Customer(String first_name, String last_name, String birth_date, String emailAddress, String username, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.emailAddress = emailAddress;
        this.username = username;
        this.password = password;
    }

    public Customer() {
    }

    @Bindable
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
        notifyPropertyChanged(BR.first_name);
    }

    @Bindable
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
        notifyPropertyChanged(BR.last_name);
    }

    @Bindable
    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
        notifyPropertyChanged(BR.birth_date);
    }

    @Bindable
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        notifyPropertyChanged(BR.emailAddress);
    }

    @Bindable
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        notifyPropertyChanged(BR.username);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }
}
