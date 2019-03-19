package com.parking.lot;

import com.parking.lot.config.ParkingLotCommand;
import com.parking.lot.model.Car;
import com.parking.lot.runnable.CreateParkingLotRunnable;
import com.parking.lot.runnable.ParkingLotCommandExecutor;
import com.parking.lot.service.ParkingLotService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * @author akshita 
 */
public class ParkingLotCommandParser {
  private static final ParkingLotService parkingLotService = new ParkingLotService();
  private static final HashMap<String, Class> commandMap = new HashMap<>();

  public ParkingLotCommandParser() {
    //if(commandMap==null | commandMap.size()==0) {
    //  populateCommandMap();
    //}
  }

  //private static void populateCommandMap() {
  //  commandMap.put(ParkingLotCommand.CREATE_PARKING_LOT.getDisplayName(), CreateParkingLotRunnable.class);
  //}
  //
  //public void parseCommand(String command) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
  //  String[] input = command.split(" ");
  //  Class classz = commandMap.get(input[0]);
  //  Constructor c = classz.getConstructor(ParkingLotService.class, Integer.class);
  //  c.newInstance(parkingLotService, input[1]);
  //}

  public void execute(String input) {
    String[] args = input.split(" ");
    switch (ParkingLotCommand.valueOf(args[0])) {
      case create_parking_lot:
        parkingLotService.createParkingLot(Integer.valueOf(args[1]));
        break;
      case status:
        parkingLotService.status();
        break;
      case park:
        parkingLotService.parkCar(new Car(args[1], args[2]));
        break;
      case leave:
        parkingLotService.unparkCar(Integer.valueOf(args[1]));
        break;
      case slot_numbers_for_cars_with_colour:
        parkingLotService.getSlotNoForCarsWithColor(args[1]);
        break;
      case slot_number_for_registration_number:
        parkingLotService.getSlotNoByCarRegNo(args[1]);
        break;
      case registration_numbers_for_cars_with_colour:
        parkingLotService.getRegNoForCarsWithColor(args[1]);
        break;

    }
  }

  public void parseFileInput(String filePath) throws IOException {
    File inputFile = new File(filePath);
    try {
      BufferedReader br = new BufferedReader(new FileReader(inputFile));
      String line;
      try {
        while ((line = br.readLine()) != null) {
          execute(line.trim());
        }
      } catch (IOException e) {
        System.out.println("Error in reading the input file.");
      }
    } catch (FileNotFoundException e) {
      System.out.println("File not found in the path specified.");
    }
  }


}
