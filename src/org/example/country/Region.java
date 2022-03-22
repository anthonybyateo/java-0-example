package org.example.country;

import java.util.ArrayList;

public class Region {
    private String name;
    private ArrayList<District> districts;

    public Region(String name, ArrayList<District> districts) {
        this.name = name;
        this.districts = districts;
    }

    public String getName() {
        return name;
    }

    public ArrayList<District> getDistricts() {
        return districts;
    }

    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                ", districts=" + districts +
                '}';
    }
}
