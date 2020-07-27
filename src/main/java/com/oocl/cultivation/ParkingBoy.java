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

    public Boolean queryTicket(Ticket ticket, ParkingLot parkingLot) {
        if (ticket == null){
            throw new RuntimeException("Please provide your parking ticket.");
        }
        if (!parkingLot.getTickets().contains(ticket)){
            throw new RuntimeException("Unrecognized parking ticket.");
        }
        return true;
    }

    public String checkPosition(List<ParkingLot> parkingLots) {
        for (int lotIndex = 0; lotIndex < parkingLots.size(); lotIndex++) {
            ParkingLot parkingLot = parkingLots.get(lotIndex);
            if (parkingLot.getTickets().size() >= 10 && lotIndex == parkingLots.size() - 1)
                return "Not enough position.";
        }
        return "Enough position.";

    }

    public String selectPark(List<ParkingLot> parkingLotList, Ticket ticket) {
        for (int parkIndex = 0; parkIndex < parkingLotList.size(); parkIndex++) {
            ParkingLot parkingLot = parkingLotList.get(parkIndex);
            if (parkingLot.getTickets().size() < 10) {
                parkingLot.getTickets().add(ticket);
                return String.format("Car %s park in parking lot %d, Your ticket number is %s", ticket.getCarId(), parkIndex + 1, ticket.getId());
            }
        }
        return checkPosition(parkingLotList);


    }

    public Car fetchCar(Ticket ticket, List<ParkingLot> parkingLots) {
        Car fetchCar = new Car(ticket.getCarId());
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.isInPark(fetchCar))
                if (queryTicket(ticket, parkingLot))
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
