package com.intercom.user;

/**
 * User is a basic entity class - needs to be extended and used in further processing
 *
 * @author mtatarnikava
 */
public abstract class User implements Comparable {
    private double longitude;
    private double latitude;

    public User(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
