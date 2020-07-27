package com.oocl.cultivation;

import java.util.HashSet;
import java.util.Set;

public class ParkingLot {
    private Set<Ticket> tickets = new HashSet<>();

    public ParkingLot() {

    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public ParkingLot(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public String isRightTicket(Ticket ticket) {
        if (!tickets.contains(ticket))
            return "can't get car.";
        tickets.remove(ticket);
        return new ParkingBoy().giveCar(ticket).getCarId();
    }

    public boolean canPark(Car car) {
        return tickets.size() < 10;
    }

    public boolean isInPark(Car car){
        if (tickets.size()>0){
            for (Ticket ticket : tickets) {
                if (ticket.getCarId().equals(car.getCarId()))
                    return true;
            }
        }

        return false;
    }

}
