package com.oocl.cultivation.test;

import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingLogFacts {
    @Test
    void should_return_cant_get_car_when_fetching_car_given_ticket_5678_to_get_car_1_but_give_5678() {
        ParkingLot parkingLot = new ParkingLot();
        HashSet<Ticket> ticketHashSet = new HashSet<>();
        ticketHashSet.add(new Ticket("1234", "C001"));
        ticketHashSet.add(new Ticket("5678", "C002"));
        Ticket wrongTicket = new Ticket("5678", "C001");

        parkingLot.setTickets(ticketHashSet);
        String isRight = parkingLot.isRightTicket(wrongTicket);

        assertEquals("can't get car.", isRight);

    }

    @Test
    void should_return_cant_get_car_when_fetching_car_given_no_ticket_to_get_car_1_but_give_no_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        HashSet<Ticket> ticketHashSet = new HashSet<>();
        ticketHashSet.add(new Ticket("1234", "C001"));
        ticketHashSet.add(new Ticket("5678", "C002"));
        Ticket wrongTicket = null;

        parkingLot.setTickets(ticketHashSet);
        String isRight = parkingLot.isRightTicket(wrongTicket);

        assertEquals("can't get car.", isRight);
    }

}
