package com.oocl.cultivation;


import java.util.List;

public class ParkingBoy {

    TicketGenerator ticketGenerator = new TicketGenerator();

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

    public String queryTicket(Ticket ticket, ParkingLot parkingLot) {
        if (ticket == null)
            return "Please provide your parking ticket.";
            if (!parkingLot.getTickets().contains(ticket))
                return "Unrecognized parking ticket.";

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
                return String.format("Car %s park in parking lot %d", ticket.getCarId(), parkIndex + 1);
            }
        }
        return checkPosition(parkingLotList);


    }

    public Car fetchCar(Ticket ticket, List<ParkingLot> parkingLots) {
        Car fetchCar = new Car(ticket.getCarId());
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.isInPark(fetchCar))
                if (queryTicket(ticket, parkingLot).equals("is right ticket"))
                    return giveCar(ticket);
        }
        return null;

    }

    public String parkCar(List<ParkingLot> parkingLotList, Car car) {
        if (checkPosition(parkingLotList).equals("Enough position."))
            return selectPark(parkingLotList, giveTicket(car));
        return checkPosition(parkingLotList);
    }

}
