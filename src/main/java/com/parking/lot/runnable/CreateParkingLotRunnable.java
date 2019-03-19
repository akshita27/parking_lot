package com.parking.lot.runnable;

import com.parking.lot.service.ParkingLotService;

/**
 * @author akshita
 */
public class CreateParkingLotRunnable extends ParkingLotCommandExecutor{
  private final ParkingLotService parkingLotService;
  private final Integer capacity;

  public CreateParkingLotRunnable(ParkingLotService parkingLotService) {
    this.parkingLotService = parkingLotService;
    this.capacity = 0;
  }
  public CreateParkingLotRunnable(ParkingLotService parkingLotService, Integer capacity) {
    this.parkingLotService = parkingLotService;
    this.capacity = capacity;
  }

  public int getCapacity() {
    return capacity;
  }

  @Override
  protected void performTask() {
    parkingLotService.createParkingLot(capacity);
  }
}
