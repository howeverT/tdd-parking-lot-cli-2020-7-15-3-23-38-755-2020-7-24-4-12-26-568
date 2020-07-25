package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

class ParkingBoyFacts {
    @Test
    void should_return_ticket_when_parking_given_a_car() {
        String generateTicket="1234";
        ParkingBoy parkingBoy = new ParkingBoy();
        TicketGenerator generator = Mockito.mock(TicketGenerator.class);
        when(generator.generate()).thenReturn(generateTicket);
        Car car = new Car("C001");

        Ticket ticket = parkingBoy.giveTicket(car,generator);


        assertEquals("1234", ticket.getId());
    }

    @Test
    void should_return_car_when_fetching_car_given_a_ticket() {
        ParkingBoy parkingBoy = new ParkingBoy();
        String carNum = "C001";
        String ticketNum = "1234";
        Ticket ticket = new Ticket(ticketNum, carNum);

        Car car = parkingBoy.giveCar(ticket);

        assertEquals("C001", car.getCarId());
    }

    @Test
    void should_return_2_ticket_when_parking_given_2_car() {
        String generateTicketOne="1234";
        String generateTicketTwo="5678";
        ParkingBoy parkingBoy = new ParkingBoy();

        TicketGenerator generatorOne = Mockito.mock(TicketGenerator.class);
        when(generatorOne.generate()).thenReturn(generateTicketOne);

        TicketGenerator generatorTwo = Mockito.mock(TicketGenerator.class);
        when(generatorTwo.generate()).thenReturn(generateTicketTwo);
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("C001"));
        carList.add(new Car("C002"));

        Ticket ticket1 = parkingBoy.giveTicket(carList.get(0),generatorOne);
        Ticket ticket2 = parkingBoy.giveTicket(carList.get(1),generatorTwo);


        assertEquals("1234", ticket1.getId());
        assertEquals("5678", ticket2.getId());
    }

    @Test
    void should_return_correct_car_when_fetching_car_given_ticket_1234_and_5678() {
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket1 = new Ticket("1234", "C001");
        Ticket ticket2 = new Ticket("5678", "C002");

        Car car1 = parkingBoy.giveCar(ticket1);
        Car car2 = parkingBoy.giveCar(ticket2);

        assertEquals("C001", car1.getCarId());
        assertEquals("C002", car2.getCarId());

    }

    @Test
    void should_return_cant_get_car_when_fetching_car_given_fake_ticket_3456_to_get_car_C001() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy();
        HashSet<Ticket> ticketHashSet = new HashSet<>();
        ticketHashSet.add(new Ticket("1234", "C001"));
        ticketHashSet.add(new Ticket("5678", "C002"));
        Ticket fakeTicket = new Ticket("3456", "C002");
        parkingLot.setTickets(ticketHashSet);

        String result = parkingBoy.queryTicket(fakeTicket,parkingLot);


        assertEquals("Unrecognized parking ticket.", result);

    }


        assertNull(ticket);

    }
}
