package com.oocl.cultivation;


import java.util.List;

public class ParkingBoy {

    TicketGenerator ticketGenerator;

    public void setTicketGenerator(TicketGenerator ticketGenerator) {
        this.ticketGenerator = ticketGenerator;
    }

    public Ticket giveTicket(Car car) {
        if (car.getCarId() != null) {
            return new Ticket(ticketGenerator.generate(), car.getCarId());
        }
        return null;

    }

    public Car giveCar(Ticket ticket) {
        return new Car(ticket.getCarId());
    }

    public String queryTicket(Ticket ticket, List<ParkingLot> parkingLots) {
        if (ticket == null)
            return "Please provide your parking ticket.";
        for (ParkingLot lot : parkingLots) {
            if (!lot.getTickets().contains(ticket))
                return "Unrecognized parking ticket.";
        }

        return "is right ticket";
    }

    public String checkPosition(List<ParkingLot> parkingLots) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getTickets().size() >= 10)
                return "Not enough position.";
        }
        return "Enough position.";

    }

    public String selectPark(List<ParkingLot> parkingLotList, Ticket ticket) {
        for (int parkIndex = 0; parkIndex < parkingLotList.size(); parkIndex++) {
            ParkingLot parkingLot = parkingLotList.get(parkIndex);
            if (parkingLot.getTickets().size() < 10) {
                parkingLot.getTickets().add(ticket);
                return String.format("Car %s park in parking lot %d", ticket.getCarId(), parkIndex+1);
            }
        }
        return checkPosition(parkingLotList);


    }

}
