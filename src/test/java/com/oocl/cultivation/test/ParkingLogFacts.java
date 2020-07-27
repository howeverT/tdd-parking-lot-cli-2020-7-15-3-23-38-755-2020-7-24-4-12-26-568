package com.oocl.cultivation.test;


import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ParkingLogFacts {

    @Test
    void should_return_cant_get_car_when_isCorrectTicket_given_expect_ticket_1234_to_get_car_1_but_give_5678() {
        ParkingLot parkingLot = generateUtils.getParkingLotData();
        Ticket wrongTicket = new Ticket("5678", "C001");

        Throwable exception = assertThrows(RuntimeException.class, () -> parkingLot.isCorrectTicket(wrongTicket));

        assertEquals("can't get car.", exception.getMessage());

    }


    @Test
    void should_return_cant_get_car_when_isCorrectTicket_given_no_ticket_to_get_car_C001() {
        ParkingLot parkingLot = generateUtils.getParkingLotData();
        Ticket wrongTicket = null;

        Throwable exception = assertThrows(RuntimeException.class, () -> parkingLot.isCorrectTicket(wrongTicket));

        assertEquals("can't get car.", exception.getMessage());
    }

    @Test
    void should_return_cant_get_car_when_isCorrectTicket_given_used_ticket_1234_to_get_car_C001() {
        ParkingLot parkingLot = generateUtils.getParkingLotData();
        Ticket usedTicket = new Ticket("1234", "C001");

        parkingLot.isCorrectTicket(usedTicket);
        Throwable exception = assertThrows(RuntimeException.class, () -> parkingLot.isCorrectTicket(usedTicket));

        assertEquals("can't get car.", exception.getMessage());


    }

    @Test
    void should_return_ticket_when_parking_car_given_park_lot_remain_place_10() {
        String generateTicket = "2345";
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = generateUtils.getParkingLotData();
        Car parkCar = new Car("C003");
        Ticket ticket = new Ticket(parkCar.getCarId());
        TicketGenerator generator = Mockito.mock(TicketGenerator.class);
        when(generator.generate()).thenReturn(generateTicket);
        parkingBoy.setTicketGenerator(generator);

        if (parkingLot.canPark(parkCar))
            ticket = parkingBoy.giveTicket(parkCar);


        assertEquals("2345", ticket.getId());

    }

    @Test
    void should_return_no_place_to_park_when_parking_car_given_park_lot_remain_place_0() {
        String generateTicket = "3456";
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = generateUtils.getMoreParkingLotData();
        Car parkCar = new Car("C011");
        TicketGenerator generator = Mockito.mock(TicketGenerator.class);
        when(generator.generate()).thenReturn(generateTicket);
        parkingBoy.setTicketGenerator(generator);

        String result;
        if (parkingLot.canPark(parkCar))
            result = parkingBoy.giveTicket(parkCar).getId();
        else
            result = "no place to park car";

        assertEquals("no place to park car", result);
    }

    @Test
    void should_return_car_in_the_park_lot_when_parking_car_C001_given_car_C001() {
        String generateTicket = "4567";
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = generateUtils.getParkingLotData();
        Car parkCar = new Car("C001");
        TicketGenerator generator = Mockito.mock(TicketGenerator.class);
        when(generator.generate()).thenReturn(generateTicket);
        parkingBoy.setTicketGenerator(generator);

        String result;
        if (parkingLot.canPark(parkCar)) {
            if (!parkingLot.isInPark(parkCar))
                result = parkingBoy.giveTicket(parkCar).getId();
            else
                result = "the car is in the park lot";
        } else
            result = "no place to park car";


        assertEquals("the car is in the park lot", result);
    }

}
