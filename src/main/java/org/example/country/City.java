package org.example.country;

public class City {
    private String name;
    private boolean isStateCapital;
    private boolean isCountryCapital;

    public City(String name) {
        this.name = name;
        this.isStateCapital = false;
        this.isCountryCapital = false;
    }


    public City(String name, boolean isStateCapital, boolean isCountryCapital) {
        this.name = name;
        this.isStateCapital = isStateCapital;
        this.isCountryCapital = isCountryCapital;
    }

    public String getName() {
        return name;
    }

    public boolean isStateCapital() {
        return isStateCapital;
    }

    public boolean isCountryCapital() {
        return isCountryCapital;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", isStateCapital=" + isStateCapital +
                ", isCountryCapital=" + isCountryCapital +
                '}';
    }
}
