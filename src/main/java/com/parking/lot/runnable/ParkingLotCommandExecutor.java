package com.parking.lot.runnable;

/**
 * @author akshita
 */
public abstract class ParkingLotCommandExecutor implements Runnable{
  @Override
  public void run() {
    performTask();
  }

  protected abstract void performTask();

}
