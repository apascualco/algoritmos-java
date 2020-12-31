package com.apascualco.algoritmos.bcu;

class Connection {

    private Integer distance;
    private String city;

    private Connection(final String city, final Integer distance) {
        this.distance = distance;
        this.city = city;
    }

    static Connection of(final String destination, final Integer distance) {
        return new Connection(destination, distance);
    }

    Integer getDistance() {
        return distance;
    }

    void setDistance(final Integer distance) {
        this.distance = distance;
    }

    String getCity() {
        return city;
    }
}
