package com.oocl.cultivation;

import java.util.HashSet;
import java.util.List;

public class TicketGenerator {
    List<ParkingLot> parkingLots;
    HashSet<String> ticketNumSet;

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        for (ParkingLot parkingLot : this.parkingLots) {
            for (Ticket ticket : parkingLot.getTickets()) {
                ticketNumSet.add(ticket.getId());
            }
        }
    }

    public String generate() {
        String generateTicketNum = String.valueOf((int) ((Math.random() * 9 + 1) * 1000));
        while (ticketNumSet != null && ticketNumSet.contains(generateTicketNum)) {
            generateTicketNum = String.valueOf((int) ((Math.random() * 9 + 1) * 1000));
        }

        return generateTicketNum;
    }
}
