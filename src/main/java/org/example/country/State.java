package org.example.country;

import java.util.ArrayList;

public class State {
    private String name;
    private ArrayList<Region> regions;

    public State(String name, ArrayList<Region> regions) {
        this.name = name;
        this.regions = regions;
    }

    public void printCapital() {
        for (Region region : regions) {
            for (District district : region.getDistricts()) {
                for (City city : district.getCities()) {
                    if (city.isCountryCapital()) {
                        System.out.println(city);
                    }
                }
            }
        }
    }

    public void printStateCount() {
        System.out.println(regions.size());
    }

    public void printSquare() {
        int totalSquare = 0;
        for (Region region : regions) {
            for (District district : region.getDistricts()) {
                totalSquare += district.getSquare();
            }
        }
        System.out.println(totalSquare);
    }

    public void printStateCapitals() {
        for (Region region : regions) {
            for (District district : region.getDistricts()) {
                for (City city : district.getCities()) {
                    if (city.isStateCapital()) {
                        System.out.println(city);
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", states=" + regions +
                '}';
    }
}
