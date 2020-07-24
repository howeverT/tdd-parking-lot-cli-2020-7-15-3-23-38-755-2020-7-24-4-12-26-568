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
        String carNum = "C001";
        String ticketNum = "1234";
        Ticket ticket = new Ticket(ticketNum, carNum);

        Car car = parkingBoy.giveCar(ticket);

        assertEquals("C001", car.getCarId());
    }

    @Test
    void should_return_2_ticket_when_parking_given_2_car() {
        ParkingBoy parkingBoy = new ParkingBoy();
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("C001"));
        carList.add(new Car("C002"));

        Ticket ticket1 = parkingBoy.giveTicket(carList.get(0));
        Ticket ticket2 = parkingBoy.giveTicket(carList.get(1));


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
}
