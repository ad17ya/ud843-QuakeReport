package com.example.android.quakereport;

public class EarthquakeObject {

    private double magnitude;
    private String location;
    private long mTimeInMilliseconds;

    public EarthquakeObject(double magnitude, String location, long timeInMilliseconds){
        this.magnitude = magnitude;
        this.location = location;
        this.mTimeInMilliseconds = timeInMilliseconds;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public long getmTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }
}
