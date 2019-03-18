package com.parking.lot.config;

/**
 * @author akshita
 */
public enum ParkingLotCommand {
  CREATE_PARKING_LOT("create_parking_lot"),
  PARK_CAR("park"),
  UNPARK_CAR("leave"),
  STATUS("status"),
  REGISTRATION_NUMBERS_FOR_CARS_WITH_COLORS("registration_numbers_for_cars_with_colour"),
  SLOT_NUMBERS_FOR_CARS_WITH_COLORS("slot_numbers_for_cars_with_colour"),
  SLOT_NUMBER_FOR_REGISTRATION_NUMBER("slot_number_for_registration_number");

  private String displayName;

  ParkingLotCommand(String displayName) {
    this.displayName = displayName;
  }

  public String getDisplayName() {
    return displayName;
  }
}
