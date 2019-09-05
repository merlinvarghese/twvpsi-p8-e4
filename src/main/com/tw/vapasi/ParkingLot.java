package com.tw.vapasi;

import java.util.HashSet;
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

    private boolean isVehicleNotParked(Parkable vehicle) {
        return !slot.contains(vehicle);
    }

    void park(Parkable vehicle) throws ParkException {
        if (!isSlotAvailable()) {
            throw new ParkException();
        }
        slot.add(vehicle);
    }

    void unpark(Parkable parkable) throws ParkException {
        if (isVehicleNotParked(parkable)) {
            throw new ParkException();
        }
        slot.remove(parkable);
    }

    boolean IsVehicleParked(Parkable vehicle)
    {
        return slot.contains(vehicle);
    }

}
