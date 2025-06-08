package com.northcoders.eventapp.model;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Staff implements Parcelable {
    Long id;
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

    protected Staff(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        first_name = in.readString();
        last_name = in.readString();
        birth_date = in.readString();
        emailAddress = in.readString();
        username = in.readString();
        password = in.readString();
        role = in.readString();
    }



    public static final Creator<Staff> CREATOR = new Creator<Staff>() {
        @Override
        public Staff createFromParcel(Parcel in) {
            return new Staff(in);
        }

        @Override
        public Staff[] newArray(int size) {
            return new Staff[size];
        }
    };

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(id);
        }
        parcel.writeString(first_name);
        parcel.writeString(last_name);
        parcel.writeString(birth_date);
        parcel.writeString(emailAddress);
        parcel.writeString(username);
        parcel.writeString(password);
        parcel.writeString(role);
    }
}
