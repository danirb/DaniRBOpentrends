package com.devforbest.danirbopentrends.models;

/**
 * Created by dani on 13/09/16.
 */


public class Human {
    private String gender;
    private int number;
    private String thumbnail;
    private String picture;
    private String descritpion;

    public Human(String gender, int number, String thumbnail, String picture, String descritpion) {
        this.gender = gender;
        this.number = number;
        this.thumbnail = thumbnail;
        this.picture = picture;
        this.descritpion = descritpion;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }
}
