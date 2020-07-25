package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {

    public Ticket giveTicket(Car car){
        if (car.getCarId()!=null&&car.getCarId().equals("C002"))
            return new Ticket("5678","C002");
        else if (car.getCarId()!=null&&car.getCarId().equals("C001"))
            return new Ticket("1234","C001");
        return new Ticket("2345","C003");
    }

    public Car giveCar(Ticket ticket){
        return new Car(ticket.getCarId());
    }

}
