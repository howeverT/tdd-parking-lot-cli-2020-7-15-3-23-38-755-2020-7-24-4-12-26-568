package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.Ticket;
import com.oocl.cultivation.ParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingBoyFacts {
    @Test
    void should_return_ticket_when_parking_given_a_car() {
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();

        Ticket ticket = parkingBoy.giveTicket(car);


        assertEquals("1234", ticket.getId());
    }

    @Test
    void should_return_car_when_fetching_car_given_a_ticket() {
        ParkingBoy parkingBoy = new ParkingBoy();
        String carNum = "1234";
        Ticket ticket = new Ticket(carNum);

        Car car = parkingBoy.giveCar(ticket);

        assertEquals("1234", car.getCarId());
    }

    @Test
    void should_return_2_ticket_when_parking_given_2_car() {
        ParkingBoy parkingBoy = new ParkingBoy();
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("1234"));
        carList.add(new Car("5678"));

        List<Ticket> ticketList = parkingBoy.giveMultiTicket(carList);
        StringBuilder result = new StringBuilder();
        if (ticketList != null) {
            for (Ticket ticket : ticketList) {
                result.append(String.format("%s,", ticket.getCarId()));
            }
        }


        assertEquals("1234,5678", result.toString());
    }
}
