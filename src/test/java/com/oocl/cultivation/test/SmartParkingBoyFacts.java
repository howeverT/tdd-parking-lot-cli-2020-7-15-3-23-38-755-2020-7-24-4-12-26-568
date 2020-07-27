package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SmartParkingBoyFacts {
    @Test
    void should_return_C001_park_in_the_park_lot_1_and_C002_park_in_the_park_lot_2_when_parking_car_given_2_car() {
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());

        String resultOne = smartParkingBoy.parkCar(parkingLots, new Car("C001"));
        String resultTwo = smartParkingBoy.parkCar(parkingLots, new Car("C002"));

        assertEquals("Car C001 park in parking lot 1", resultOne.substring(0,30));
        assertEquals("Car C002 park in parking lot 2", resultTwo.substring(0,30));

    }

    @Test
    void should_return_C003_park_in_the_park_lot_1_when_parking_car_given_3_car() {
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());

        smartParkingBoy.parkCar(parkingLots, new Car("C001"));
        smartParkingBoy.parkCar(parkingLots, new Car("C002"));
        String result = smartParkingBoy.parkCar(parkingLots, new Car("C003"));

        assertEquals("Car C003 park in parking lot 1", result.substring(0,30));
    }

    @Test
    void should_return_not_enough_position_when_parking_car_given_0_position() {
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());

        generateUtils.getMoreParkCar(smartParkingBoy, parkingLots);
        Throwable exception = assertThrows(RuntimeException.class, () -> smartParkingBoy.parkCar(parkingLots, new Car("C011")));

        assertEquals("Not enough position.", exception.getMessage());
    }


    @Test
    void should_return_correct_car_when_fetching_car_given_a_ticket() {
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        List<ParkingLot> parkingLots = new ArrayList<>();
        Ticket ticket = new Ticket("1234", "C001");
        parkingLots.add(generateUtils.getParkingLotData());

        Car fetchCar = smartParkingBoy.fetchCar(ticket, parkingLots);

        assertEquals("C001", fetchCar.getCarId());


    }
}
