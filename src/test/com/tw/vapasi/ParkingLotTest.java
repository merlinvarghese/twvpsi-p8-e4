package com.tw.vapasi;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParkingLotTest implements Parkable {

    @Test
    void expectVehicleParkingIsSuccessful() {

        Parkable vehicle = new Vehicle();
        ParkingLot parkingLot = new ParkingLot(30);
        try {
            //Act
            parkingLot.park(vehicle);
            // Assert
        } catch (ParkException e) {
            Assertions.fail("It has thrown an exception");
        }
    }

    @Test
    void expectVehicleParkingIsNotSuccessfulWhenSlotIsNotAvailable() throws ParkException {
        Parkable vehicle = new Vehicle();
        Parkable otherVehicle = new Vehicle();
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(otherVehicle);
        try {
            //Act
            parkingLot.park(vehicle);
            // Assert
            Assertions.fail("It has thrown an exception");
        } catch (ParkException e) {
            // passed
        }
    }

    @Test
    void expectUnParkFailsWhenAVehicleNotAlreadyParked() {
        Parkable vehicle = new Vehicle();
        ParkingLot parkingLot = new ParkingLot(30);
        try {
            //Act
            parkingLot.unPark(vehicle);
            // Assert
            Assertions.fail("It has thrown an exception");
        } catch (ParkException e) {
            // passed
        }
    }

    @Test
    void expectUnParkSuccessWhenVehicleIsParked() throws ParkException {
        Parkable vehicle = new Vehicle();

        ParkingLot parkingLot = new ParkingLot(30);
        parkingLot.park(vehicle);
        try {
            //Act
            parkingLot.unPark(vehicle);
            // Assert

        } catch (ParkException e) {
            Assertions.fail("It has thrown an exception");
        }
    }
}
