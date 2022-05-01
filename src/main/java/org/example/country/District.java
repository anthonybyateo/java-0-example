package org.example.country;

import java.util.ArrayList;

public class District {
    private String name;
    private int square;
    private ArrayList<City> cities;

    public District(String name, int square, ArrayList<City> cities) {
        this.name = name;
        this.square = square;
        this.cities = cities;
    }

    public String getName() {
        return name;
    }

    public int getSquare() {
        return square;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    @Override
    public String toString() {
        return "District{" +
                "name='" + name + '\'' +
                ", square=" + square +
                ", cities=" + cities +
                '}';
    }
}
