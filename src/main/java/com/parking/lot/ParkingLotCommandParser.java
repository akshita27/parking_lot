package com.parking.lot;

import com.parking.lot.config.ParkingLotCommand;
import com.parking.lot.runnable.CreateParkingLotRunnable;
import com.parking.lot.runnable.ParkingLotCommandExecutor;
import com.parking.lot.service.ParkingLotService;

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
    if(commandMap==null | commandMap.size()==0) {
      populateCommandMap();
    }
  }

  private static void populateCommandMap() {
    commandMap.put(ParkingLotCommand.CREATE_PARKING_LOT.getDisplayName(), CreateParkingLotRunnable.class);
  }

  public void parseCommand(String command) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
    String[] input = command.split(" ");
    Class classz = commandMap.get(input[0]);
    Constructor c = classz.getConstructor(ParkingLotService.class, Integer.class);
    c.newInstance(parkingLotService, input[1]);
  }


}
