package org.example.car;

public class Tank {
    private int volume;

    public Tank() {
        this.volume = 0;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Tank{" + "volume=" + volume + "}";
    }

}
