package com.northcoders.eventapp.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.northcoders.eventapp.BR;

public class Login extends BaseObservable {
    String username;
    String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Login() {
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
