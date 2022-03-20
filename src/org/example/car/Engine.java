package org.example.car;

public class Engine {
    public String type;

    public Engine(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Engine{" + "type=" + type + "}";
    }

}
