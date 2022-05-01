package org.example.car;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String mark;
    private Engine engine;
    private Tank tank;
    private List<Wheel> wheels;

    public Car(String mark) {
        this.mark = mark;
        this.engine = new Engine("Some engine type");
        this.tank = new Tank();
        this.wheels = new ArrayList<>(List.of(new Wheel(), new Wheel(), new Wheel(), new Wheel()));
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public String getMark() {
        return mark;
    }

    public void move() {
        System.out.println("move");
    }

    public void fillUp(int litres) {
        tank.setVolume(litres);
    }

    public void changeWheelById(String id, Wheel newWheel) {
        Wheel oldWheel = null;
        for (Wheel wheel: wheels) {
            if (wheel.getId().equals(id)) {
                oldWheel = wheel;
            }
        }

        wheels.remove(oldWheel);
        wheels.add(newWheel);
    }

    @Override
    public String toString() {
        return "Car{" + "mark=" + mark + ", engine=" + engine + ", tank=" + tank + ", wheels=" + wheels + "}";
    }

}
