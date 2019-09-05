package com.tw.vapasi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ParkingLot {
    private final int size;
    private final Set<Parkable> slot;


    ParkingLot(int size) {
        this.size = size;
        this.slot = new HashSet<>();
    }

    private boolean isSlotAvailable() {
        return slot.size() < size;
    }

    void park(Parkable vehicle) throws ParkException {
        if (!isSlotAvailable()) {
            throw new ParkException();
        }
        slot.add(vehicle);
    }

    private boolean isVehicleParked(Parkable vehicle) {
        return slot.contains(vehicle);
    }

    void unPark(Parkable vehicle) throws ParkException {
        if (!isVehicleParked(vehicle)) {
            throw new ParkException();
        }
        slot.remove(vehicle);
    }
}
