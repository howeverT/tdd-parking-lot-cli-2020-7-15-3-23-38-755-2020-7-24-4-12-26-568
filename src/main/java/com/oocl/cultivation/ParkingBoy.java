package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {

    public Ticket giveTicket(Car car){
        return new Ticket("1234");
    }

    public Car giveCar(Ticket ticket){
        return new Car(ticket.getCarId());
    }

    public List<Ticket> giveMultiTicket(List<Car> cars){
        return null;
    }
}
