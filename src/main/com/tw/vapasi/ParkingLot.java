package com.tw.vapasi;

import javax.swing.plaf.IconUIResource;
import java.util.HashSet;
import java.util.Set;

class ParkingLot {
    private final int size;
    private final Set<Parkable> slot;
    ParkingLotOwner owner;


    ParkingLot(int size) {
        this.size = size;
        this.slot = new HashSet<>();
    }

    ParkingLot(int size, ParkingLotOwner owner) {
        this.size = size;
        this.slot = new HashSet<>();
        this.owner  = owner;
    }

     boolean isSlotAvailable() {
        return slot.size() <= size;
    }

    private boolean isVehicleNotParked(Parkable vehicle) {
        return !slot.contains(vehicle);
    }

    void park(Parkable vehicle) throws ParkException {
        if (!isSlotAvailable()) {
            throw  new ParkException();
        }
        slot.add(vehicle);
        if (!isSlotAvailable()) {
            owner.notifyParkingLotFull();
        }
    }

    void unPark(Parkable parkable) throws ParkException {
        if (isVehicleNotParked(parkable)) {
            throw new ParkException();
        }
        if (!isSlotAvailable()) {
            owner.notifyParkingLotAvailable();
        }
        slot.remove(parkable);
    }

    boolean IsVehicleParked(Parkable vehicle)
    {
        return slot.contains(vehicle);
    }


}
