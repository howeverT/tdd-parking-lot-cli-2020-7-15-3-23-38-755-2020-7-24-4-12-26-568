package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        Car parkCar = new Car("C001");
        String result = superSmartParkingBoy.parkCar(parkingLots, parkCar);
        System.out.println(result);
        String ticketId = result.substring(result.length() - 4);


        Ticket ticket = new Ticket(ticketId, "C001");
        Car fetchCar = superSmartParkingBoy.fetchCar(ticket, parkingLots);
        System.out.println("fetch car " +fetchCar.getCarId());

    }
}
