package com.oocl.cultivation.test;

import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.TicketGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeneratorTest {
    @Test
    void should_return_4_when_generate_number() {
        TicketGenerator ticketGenerator = new TicketGenerator();
        List<ParkingLot> parkingLots=new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ticketGenerator.setParkingLots(parkingLots);

        String result = ticketGenerator.generate();

        assertEquals(4, result.length());
    }
}
