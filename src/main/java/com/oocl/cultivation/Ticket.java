package com.oocl.cultivation;

import java.util.Objects;

public class Ticket {
    private String id;
    private String carId;


    public Ticket(String carId) {
        this.carId = carId;
        this.id=this.generate();
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

    public String generate(){
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) &&
                Objects.equals(carId, ticket.carId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carId);
    }
}
