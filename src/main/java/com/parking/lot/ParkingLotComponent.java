package com.parking.lot;

import com.parking.lot.api.ParkingLotAPI;
import com.parking.lot.impl.ParkingLotImpl;
import com.parking.lot.model.Car;
import com.parking.lot.service.ParkingLotService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

/**
 * @author akshita
 */
public class ParkingLotComponent {
  public static void main(String [] args) throws IOException {
    //ParkingLotService parkingLotService = new ParkingLotService();
    //ParkingLotAPI parkingLotAPI = new ParkingLotImpl(parkingLotService);
    //
    //parkingLotAPI.createParkingLot(6);
    //parkingLotAPI.parkCar(new Car("KA-01-HH-1234", "White"));
    //parkingLotAPI.parkCar(new Car("KA-01-HH-9999", "White"));
    //parkingLotAPI.parkCar(new Car("KA-01-BB-0001", "Black"));
    //parkingLotAPI.parkCar(new Car("KA-01-HH-7777", "Red"));
    //parkingLotAPI.parkCar(new Car("KA-01-HH-2701", "Blue"));
    //parkingLotAPI.parkCar(new Car("KA-01-HH-3141", "Black"));
    //parkingLotAPI.unparkCar(4);
    //parkingLotAPI.status();
    //parkingLotAPI.parkCar(new Car("KA-01-P-333", "White"));
    //parkingLotAPI.parkCar(new Car("DL-12-AA-9999", "White"));
    //parkingLotAPI.getRegNoForCarsWithColor("White");
    //parkingLotAPI.getSlotNoForCarsWithColor("White");
    //parkingLotAPI.getSlotNoByCarRegNo("KA-01-HH-3141");
    //parkingLotAPI.getSlotNoByCarRegNo("MH-04-AY-1111");

    ParkingLotCommandParser inputParser = new ParkingLotCommandParser();
    switch(args.length){
      case 0:
        // Interactive input
        System.out.println("Please enter 'exit' to quit the prompt!");
        System.out.println("May the force be with you...Lets's begin!");
        while(true){
          try{
            BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();
            if(input.isEmpty()){
              continue;
            }
            if(input.equalsIgnoreCase("exit")){
              break;
            }
            else{
              inputParser.parseCommand(input);
            }
          }
          catch (IOException e){
            System.out.println("Error in reading input from console.");
            e.printStackTrace();
          } catch (NoSuchMethodException e) {
            e.printStackTrace();  // TODO impl
          } catch (InstantiationException e) {
            e.printStackTrace();  // TODO impl
          } catch (IllegalAccessException e) {
            e.printStackTrace();  // TODO impl
          } catch (InvocationTargetException e) {
            e.printStackTrace();  // TODO impl
          }
        }
        break;
      case 1:
        // File input
        //inputParser.parseFileInput(args[0]);
        break;
      default:
        System.out.println("Sorry! Invalid input. Please try again...!");
    }
    
  }
}
