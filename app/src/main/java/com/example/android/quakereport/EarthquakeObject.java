package com.example.android.quakereport;

public class EarthquakeObject {

    private double magnitude;
    private String location;
    private long mTimeInMilliseconds;
    private String mUrl;

    public EarthquakeObject(double magnitude, String location, long timeInMilliseconds, String url){
        this.magnitude = magnitude;
        this.location = location;
        this.mTimeInMilliseconds = timeInMilliseconds;
        this.mUrl = url;
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

    public String getmUrl() {
        return mUrl;
    }
}
