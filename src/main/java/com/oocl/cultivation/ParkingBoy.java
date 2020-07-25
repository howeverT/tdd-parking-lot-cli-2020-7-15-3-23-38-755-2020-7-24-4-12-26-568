package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {

    public Ticket giveTicket(Car car, TicketGenerator ticketGenerator) {
        if (car != null && car.getCarId() != null) {
            return new Ticket(ticketGenerator.generate(), car.getCarId());
        }
        return null;

    }

    public Car giveCar(Ticket ticket) {
        return new Car(ticket.getCarId());
    }

    public String queryTicket(Ticket ticket,ParkingLot parkingLot){
        if (!parkingLot.getTickets().contains(ticket))
            return "Unrecognized parking ticket.";
        return "is right ticket";
    }

}
