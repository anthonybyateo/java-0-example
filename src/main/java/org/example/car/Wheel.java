package org.example.car;

import java.util.UUID;

public class Wheel {
    private String id;

    public Wheel() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Wheel{" + "id=" + id + "}";
    }

}
