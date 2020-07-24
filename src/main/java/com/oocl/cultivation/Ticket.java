package com.oocl.cultivation;

public class Ticket {
    private String id;
    private String carId;


    public Ticket(String id) {
        this.id = id;
    }

    public Ticket(String id, String carId) {
        this.id = id;
        this.carId = carId;
    }

    public String getCarId() {
        return carId;
    }

    public String getId() {
        return id;
    }
}
