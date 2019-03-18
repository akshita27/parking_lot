package com.parking.lot.api;

import com.parking.lot.model.Car;

/**
 * @author akshita
 */
public interface ParkingLotAPI {
  void createParkingLot(int capacity);
  void parkCar(Car car);
  void unparkCar(int slotNo);
  void getRegNoForCarsWithColor(String color);
  void getSlotNoForCarsWithColor(String color);
  void getSlotNoByCarRegNo(String regNo);
  void status();
}
