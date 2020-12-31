package com.apascualco.algoritmos.astar;

public class City {

    private String name;
    private Coords coords;


    private City(final String name, final Coords coords) {
        this.name = name;
        this.coords = coords;
    }

    public static City of(final String city, final Coords coords) {
        return new City(city,coords);
    }

    public String getName() {
        return name;
    }

    public Coords getCoords() {
        return coords;
    }
}
