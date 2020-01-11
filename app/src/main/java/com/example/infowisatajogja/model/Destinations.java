package com.example.infowisatajogja.model;

public class Destinations {

    private String Price;
    private String Ship;
    private String Title;
    private String Date;
    private String Visiting;
    private String Photo;

    public Destinations() {
    }

    public Destinations(String price, String ship, String title, String date, String visiting, String photo) {
        Price = price;
        Ship = ship;
        Title = title;
        Date = date;
        Visiting = visiting;
        Photo = photo;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getShip() {
        return Ship;
    }

    public void setShip(String ship) {
        Ship = ship;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getVisiting() {
        return Visiting;
    }

    public void setVisiting(String visiting) {
        Visiting = visiting;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }
}
