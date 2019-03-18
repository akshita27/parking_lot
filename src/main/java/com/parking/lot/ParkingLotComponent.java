package com.parking.lot;

import com.parking.lot.api.ParkingLotAPI;
import com.parking.lot.impl.ParkingLotImpl;
import com.parking.lot.model.Car;
import com.parking.lot.service.ParkingLotService;

/**
 * @author akshita
 */
public class ParkingLotComponent {
  public static void main(String [] args) {
    ParkingLotService parkingLotService = new ParkingLotService();
    ParkingLotAPI parkingLotAPI = new ParkingLotImpl(parkingLotService);

    parkingLotAPI.createParkingLot(6);
    parkingLotAPI.parkCar(new Car("KA-01-HH-1234", "White"));
    parkingLotAPI.parkCar(new Car("KA-01-HH-9999", "White"));
    parkingLotAPI.parkCar(new Car("KA-01-BB-0001", "Black"));
    parkingLotAPI.parkCar(new Car("KA-01-HH-7777", "Red"));
    parkingLotAPI.parkCar(new Car("KA-01-HH-2701", "Blue"));
    parkingLotAPI.parkCar(new Car("KA-01-HH-3141", "Black"));
    parkingLotAPI.unparkCar(4);
    parkingLotAPI.status();
    parkingLotAPI.parkCar(new Car("KA-01-P-333", "White"));
    parkingLotAPI.parkCar(new Car("DL-12-AA-9999", "White"));
    parkingLotAPI.getRegNoForCarsWithColor("White");
    parkingLotAPI.getSlotNoForCarsWithColor("White");
    parkingLotAPI.getSlotNoByCarRegNo("KA-01-HH-3141");
    parkingLotAPI.getSlotNoByCarRegNo("MH-04-AY-1111");
    
  }
}
