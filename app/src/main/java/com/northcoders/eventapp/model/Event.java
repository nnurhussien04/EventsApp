package com.northcoders.eventapp.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.northcoders.eventapp.BR;

public class Event extends BaseObservable {
    String name;
    String description;
    String date;
    String time;
    String location;
    Staff staff;
    public Event(String name, String description, String date, String time, String location, Staff staff) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.time = time;
        this.location = location;
        this.staff = staff;
    }

    public Event() {
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }

    @Bindable
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
        notifyPropertyChanged(BR.date);
    }

    @Bindable
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
        notifyPropertyChanged(BR.time);
    }

    @Bindable
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
        notifyPropertyChanged(BR.location);
    }

    @Bindable
    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
        notifyPropertyChanged(BR.staff);
    }


    public String getCompleteName(){
        return staff.first_name + " " + staff.last_name;
    }
}
