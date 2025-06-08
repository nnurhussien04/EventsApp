package com.northcoders.eventapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.northcoders.eventapp.BR;

public class Event extends BaseObservable implements Parcelable {
    Long id;
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

    protected Event(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        name = in.readString();
        description = in.readString();
        date = in.readString();
        time = in.readString();
        location = in.readString();
        staff = in.readParcelable(Staff.class.getClassLoader());
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

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
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(date);
        parcel.writeString(time);
        parcel.writeString(location);
        parcel.writeParcelable(staff, i);
    }


}
