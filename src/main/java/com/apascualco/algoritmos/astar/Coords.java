package com.apascualco.algoritmos.astar;

public class Coords {

    private double latitude;
    private double longitude;

    public Coords(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static Coords of(double latitude, double longitude) {
        return new Coords(latitude,longitude);
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
