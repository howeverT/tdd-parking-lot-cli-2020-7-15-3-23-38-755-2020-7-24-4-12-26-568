package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SmartParkingBoy;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyFacts {
    @Test
    void should_return_C001_park_in_the_park_lot_1_and_C002_park_in_the_park_lot_2_when_parking_car_given_2_car() {
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());

        String resultOne = smartParkingBoy.selectPark(parkingLots, new Ticket("C001"));
        String resultTwo = smartParkingBoy.selectPark(parkingLots, new Ticket("C002"));

        assertEquals("Car C001 park in parking lot 1", resultOne);
        assertEquals("Car C002 park in parking lot 2", resultTwo);

    }

    @Test
    void should_return_C003_park_in_the_park_lot_1_when_parking_car_given_3_car() {
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());

        smartParkingBoy.selectPark(parkingLots, new Ticket("C001"));
        smartParkingBoy.selectPark(parkingLots, new Ticket("C002"));
        String result = smartParkingBoy.selectPark(parkingLots, new Ticket("C003"));

        assertEquals("Car C003 park in parking lot 1", result);
    }

    @Test
    void should_return_not_enough_position_when_parking_car_given_0_position() {
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());

        smartParkingBoy.parkCar(parkingLots, new Car("C001"));
        smartParkingBoy.parkCar(parkingLots, new Car("C002"));
        smartParkingBoy.parkCar(parkingLots, new Car("C003"));
        smartParkingBoy.parkCar(parkingLots, new Car("C004"));
        smartParkingBoy.parkCar(parkingLots, new Car("C005"));
        smartParkingBoy.parkCar(parkingLots, new Car("C006"));
        smartParkingBoy.parkCar(parkingLots, new Car("C007"));
        smartParkingBoy.parkCar(parkingLots, new Car("C008"));
        smartParkingBoy.parkCar(parkingLots, new Car("C009"));
        smartParkingBoy.parkCar(parkingLots, new Car("C010"));
        String result = smartParkingBoy.parkCar(parkingLots, new Car("C011"));

        assertEquals("not enough position.", result);
    }
}
