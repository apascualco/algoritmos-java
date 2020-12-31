package com.apascualco.algoritmos.astar;

class Connection {

    private Integer distance;
    private City city;

    private Connection(final City city, final Integer distance) {
        this.distance = distance;
        this.city = city;
    }

    static Connection of(final City destination, final Integer distance) {
        return new Connection(destination, distance);
    }

    Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    City getCity() {
        return city;
    }

}
