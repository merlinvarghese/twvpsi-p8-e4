package com.tw.vapasi;

import java.util.List;

public class Valet {
    List<ParkingLot> parkingLot;

    public Valet(List<ParkingLot> parkingLot) {
        this.parkingLot = parkingLot;
    }

    void park(Parkable vehicle) throws ParkException {

        for (ParkingLot valetParkingLot : parkingLot) {
            if (valetParkingLot.isSlotAvailable()) {
                valetParkingLot.park(vehicle);
                break;
            }
        }
    }

    void unPark(Parkable vehicle) throws ParkException {
        //parkingLot.unPark(vehicle);
    }

}
