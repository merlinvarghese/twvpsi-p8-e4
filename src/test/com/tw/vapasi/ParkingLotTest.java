package com.tw.vapasi;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;

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
            parkingLot.unPark(vehicle);
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

    @Test
    void expectMyVehicleIsParkedInParkingLot() throws ParkException {
        Parkable vehicle = new Vehicle();

        ParkingLot parkingLot = new ParkingLot(30);
        parkingLot.park(vehicle);

        Assertions.assertTrue(parkingLot.IsVehicleParked(vehicle));


    }

    @Test
    void expectMyVehicleIsNotParkedInParkingLot(){
        Parkable vehicle = new Vehicle();

        ParkingLot parkingLot = new ParkingLot(30);

        Assertions.assertFalse(parkingLot.IsVehicleParked(vehicle));


    }
    @Test
    void expectNotifyOwnerWhenParkingLotIsFull() throws ParkException {
        Parkable vehicle = new Vehicle();
        Parkable vehicle1 = new Vehicle();
        ParkingLotOwner owner=new Owner();

        ParkingLot parkingLot = new ParkingLot(1,owner);
        parkingLot.park(vehicle);
        parkingLot.park(vehicle1);

        Assertions.assertTrue(owner.notifyParkingLotFull());
    }

    @Test
    void expectNotifyOwnerWhenParkingLotIsAvailable() throws ParkException {
        Parkable vehicle = new Vehicle();
        Parkable vehicle1 = new Vehicle();
        ParkingLotOwner owner=new Owner();

        ParkingLot parkingLot = new ParkingLot(1,owner);
        parkingLot.park(vehicle);
        parkingLot.park(vehicle1);
        parkingLot.unPark(vehicle);

        Assertions.assertTrue(owner.notifyParkingLotAvailable());
    }
    @Test
    void expectValetIsAbleToPark() {

        Parkable vehicle = new Vehicle();
        List<ParkingLot> parkingLot = new ArrayList<>(Arrays.asList(
                new ParkingLot(1,mock(Owner.class)),
                new ParkingLot(3,mock(Owner.class)),
                new ParkingLot(5,mock(Owner.class))
                ));
        Valet valet = new Valet(parkingLot);
        try {
            //Act
           valet.park(vehicle);
            // Assert
        } catch (ParkException e) {
            Assertions.fail("It has thrown an exception");
        }
    }
}
