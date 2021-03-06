package com.oocl.cultivation;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {
    @Override
    public String selectPark(List<ParkingLot> parkingLotList, Ticket ticket) {
        if (parkingLotList != null && checkPosition(parkingLotList)) {
            float[] placeOfLot = new float[parkingLotList.size()];
            int placeIndex = 0;
            int morePlace = 0;
            for (ParkingLot parkingLot : parkingLotList) {
                placeOfLot[placeIndex++] = parkingLot.getTickets().size() / 10;
            }
            for (int selectIndex = 0; selectIndex < placeOfLot.length - 1; selectIndex++) {
                if (placeOfLot[selectIndex + 1] < 10 && placeOfLot[selectIndex] < 10 && placeOfLot[selectIndex] > placeOfLot[selectIndex + 1])
                    morePlace = selectIndex + 1;
            }
            if (morePlace != -1)
                parkingLotList.get(morePlace).getTickets().add(ticket);
            return String.format("Car %s park in parking lot %d, Your ticket number is %s", ticket.getCarId(), morePlace + 1, ticket.getId());
        }
        return null;
    }
}
