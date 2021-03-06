package com.oocl.cultivation;

import java.util.HashSet;
import java.util.List;

public class generateUtils {
    public static HashSet<Ticket> getHashTickets() {
        HashSet<Ticket> ticketHashSet = new HashSet<>();
        ticketHashSet.add(new Ticket("1234", "C001"));
        ticketHashSet.add(new Ticket("5678", "C002"));
        return ticketHashSet;
    }


    public static HashSet<Ticket> getMoreThanTenHashTickets() {
        HashSet<Ticket> ticketHashSet = new HashSet<>();
        ticketHashSet.add(new Ticket("C001"));
        ticketHashSet.add(new Ticket("C002"));
        ticketHashSet.add(new Ticket("C003"));
        ticketHashSet.add(new Ticket("C004"));
        ticketHashSet.add(new Ticket("C005"));
        ticketHashSet.add(new Ticket("C006"));
        ticketHashSet.add(new Ticket("C007"));
        ticketHashSet.add(new Ticket("C008"));
        ticketHashSet.add(new Ticket("C009"));
        ticketHashSet.add(new Ticket("C010"));
        return ticketHashSet;
    }

    public static void getMoreParkCar(ParkingBoy parkingBoy, List<ParkingLot> parkingLots) {
        parkingBoy.parkCar(parkingLots, new Car("C001"));
        parkingBoy.parkCar(parkingLots, new Car("C002"));
        parkingBoy.parkCar(parkingLots, new Car("C003"));
        parkingBoy.parkCar(parkingLots, new Car("C004"));
        parkingBoy.parkCar(parkingLots, new Car("C005"));
        parkingBoy.parkCar(parkingLots, new Car("C006"));
        parkingBoy.parkCar(parkingLots, new Car("C007"));
        parkingBoy.parkCar(parkingLots, new Car("C008"));
        parkingBoy.parkCar(parkingLots, new Car("C009"));
        parkingBoy.parkCar(parkingLots, new Car("C010"));
    }

    public static ParkingLot getParkingLotData() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setTickets(getHashTickets());
        return parkingLot;
    }

    public static ParkingLot getMoreParkingLotData() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setTickets(getMoreThanTenHashTickets());
        return parkingLot;
    }
}
