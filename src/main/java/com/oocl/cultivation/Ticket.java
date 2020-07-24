package com.oocl.cultivation;

public class Ticket {
    private String id;
    private String carId;


    public Ticket(String carId) {
        this.carId = carId;
    }

    public Ticket(CreateTicket createTicket){
        this.id=createTicket.generate();
    }

    public String getCarId() {
        return carId;
    }

    public String getId() {
        return id;
    }
}
