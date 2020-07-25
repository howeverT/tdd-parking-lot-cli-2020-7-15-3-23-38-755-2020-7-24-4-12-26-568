package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {

    public Ticket giveTicket(Car car, TicketGenerator ticketGenerator) {
        if (car.getCarId() != null) {
            return new Ticket(ticketGenerator.generate(), car.getCarId());
        }
        return null;

    }

    public Car giveCar(Ticket ticket) {
        return new Car(ticket.getCarId());
    }

    public String queryTicket(Ticket ticket, ParkingLot parkingLot) {
        if (ticket == null)
            return "Please provide your parking ticket.";
        if (!parkingLot.getTickets().contains(ticket))
            return "Unrecognized parking ticket.";
        return "is right ticket";
    }

    public String checkPosition(ParkingLot parkingLot) {
        if (parkingLot.getTickets().size()>=10)
            return "Not enough position.";
        return null;

    }

}
