package com.example.android.quakereport;

public class EarthquakeObject {

    private String magnitude;
    private String location;
    private String date;

    public EarthquakeObject(String magnitude, String location, String date){
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }
}
