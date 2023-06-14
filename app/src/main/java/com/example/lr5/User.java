package com.example.lr5;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class User implements Parcelable {
    private String Name;
    private String Surename;
    private String email;
    private double draft;

    protected User(Parcel in) {
        Name = in.readString();
        Surename = in.readString();
        email = in.readString();
        draft = in.readDouble();
    }
    public User(String name, String surename, String email, double draft)
    {
        setName(name);
        setSurename(surename);
        setEmail(email);
        setDraft(draft);
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getEmail() {
        return email;
    }

    public String getName() {
        return Name;
    }

    public String getSurename() {
        return Surename;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSurename(String surename) {
        Surename = surename;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeString(Surename);
        dest.writeString(email);
        dest.writeDouble(draft);
    }

    public void setDraft(double draft) {
        this.draft = draft;
    }

    public double getDraft() {
        return draft;
    }
}
