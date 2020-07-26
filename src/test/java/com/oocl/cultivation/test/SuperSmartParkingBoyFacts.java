package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SuperSmartParkingBoy;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperSmartParkingBoyFacts {
    @Test
    void should_return_C001_park_in_the_park_lot_1_and_C002_park_in_the_park_lot_1_when_parking_car_given_2_car() {
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());

        String resultOne = superSmartParkingBoy.selectPark(parkingLots, new Ticket("C001"));
        String resultTwo = superSmartParkingBoy.selectPark(parkingLots, new Ticket("C002"));

        assertEquals("Car C001 park in parking lot 1", resultOne);
        assertEquals("Car C002 park in parking lot 1", resultTwo);
    }

    @Test
    void should_return_not_enough_position_when_parking_car_given_0_position() {
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());

        superSmartParkingBoy.parkCar(parkingLots, new Car("C001"));
        superSmartParkingBoy.parkCar(parkingLots, new Car("C002"));
        superSmartParkingBoy.parkCar(parkingLots, new Car("C003"));
        superSmartParkingBoy.parkCar(parkingLots, new Car("C004"));
        superSmartParkingBoy.parkCar(parkingLots, new Car("C005"));
        superSmartParkingBoy.parkCar(parkingLots, new Car("C006"));
        superSmartParkingBoy.parkCar(parkingLots, new Car("C007"));
        superSmartParkingBoy.parkCar(parkingLots, new Car("C008"));
        superSmartParkingBoy.parkCar(parkingLots, new Car("C009"));
        superSmartParkingBoy.parkCar(parkingLots, new Car("C010"));
        String result = superSmartParkingBoy.parkCar(parkingLots, new Car("C011"));

        assertEquals("Not enough position.", result);
    }

    @Test
    void should_return_C011_park_in_the_park_lot_2_when_parking_car_given_11_car() {
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());

        superSmartParkingBoy.parkCar(parkingLots, new Car("C001"));
        superSmartParkingBoy.parkCar(parkingLots, new Car("C002"));
        superSmartParkingBoy.parkCar(parkingLots, new Car("C003"));
        superSmartParkingBoy.parkCar(parkingLots, new Car("C004"));
        superSmartParkingBoy.parkCar(parkingLots, new Car("C005"));
        superSmartParkingBoy.parkCar(parkingLots, new Car("C006"));
        superSmartParkingBoy.parkCar(parkingLots, new Car("C007"));
        superSmartParkingBoy.parkCar(parkingLots, new Car("C008"));
        superSmartParkingBoy.parkCar(parkingLots, new Car("C009"));
        superSmartParkingBoy.parkCar(parkingLots, new Car("C010"));
        String result = superSmartParkingBoy.parkCar(parkingLots, new Car("C011"));

        assertEquals("Car C011 park in parking lot 2", result);
    }

    @Test
    void should_return_correct_car_when_fetching_car_given_a_ticket_and_super_smart_boy() {
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();
        List<ParkingLot> parkingLots = new ArrayList<>();
        Ticket ticket = new Ticket("1234", "C001");
        parkingLots.add(new ParkingLot());
        HashSet<Ticket> ticketHashSet = new HashSet<>();
        ticketHashSet.add(new Ticket("1234", "C001"));
        ticketHashSet.add(new Ticket("5678", "C002"));
        parkingLots.get(0).setTickets(ticketHashSet);

        Car fetchCar = superSmartParkingBoy.fetchCar(ticket, parkingLots);

        assertEquals("C001", fetchCar.getCarId());
    }
}
