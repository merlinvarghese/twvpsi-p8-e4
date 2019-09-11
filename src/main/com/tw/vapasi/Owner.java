package com.tw.vapasi;

public class Owner  implements  ParkingLotOwner{
    @Override
    public boolean notifyParkingLotFull() {
         return  true;
    }

    @Override
    public boolean notifyParkingLotAvailable() {
           return  true;
    }
}
