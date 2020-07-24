package com.oocl.cultivation;

public class ParkingBoy {

    public Ticket giveTicket(Car car){
        return new Ticket("1234");
    }

    public Car giveCar(Ticket ticket){
        return new Car(ticket.getCarId());
    }
}
