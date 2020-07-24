package com.oocl.cultivation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParkingLot {
    private Set<Ticket> tickets=new HashSet<>();

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public String isRightTicket(Ticket ticket){
        if (!tickets.contains(ticket))
            return "can't get car.";
        tickets.remove(ticket);
        return new ParkingBoy().giveCar(ticket).getCarId();
    }
}
