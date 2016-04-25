package com.augustosalazar.androidjson;


import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DataEntry implements Serializable {

    private String gender;
    private String fistName;
    private String lastName;
    private String email;
    private String picture;
    private String firebase;

    public DataEntry() {

    }

    public DataEntry(String gender, String fistName, String lastName, String email, String picture, String firebase) {
        this.gender = gender;
        this.fistName = fistName;
        this.lastName = lastName;
        this.email = email;
        this.picture = picture;
        this.firebase = firebase;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getFirebase() {
        return firebase;
    }

    public void setFirebase(String firebase) {
        this.firebase = firebase;
    }
}
