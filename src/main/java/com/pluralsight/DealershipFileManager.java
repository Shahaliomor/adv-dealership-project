package com.pluralsight;

import java.io.*;

public class DealershipFileManager {
    public static Dealership getDealership(){
        Dealership dealership=null;
        try {
            BufferedReader read=new BufferedReader(new FileReader("src/main/resources/inventory.csv"));
            String header=read.readLine();
            String[] headpart=header.split("\\|");

            dealership=new Dealership(headpart[0],headpart[1],headpart[2]);
            String line;
            while ((line=read.readLine())!=null){
                String[] parts=line.split("\\|");
                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String vehicleType = parts[4];
                String colour = parts[5];
                int odoMeter = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);
                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, colour, odoMeter, price);
                dealership.addVehicle(vehicle);
            }



        } catch (FileNotFoundException e) {
            System.out.println(e);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }







        return dealership;
    }

    public static void saveDealership(Dealership dealership) {
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("src/main/resources/inventory.csv")
            );

            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            writer.newLine();

            for (Vehicle vehicle : dealership.getAllVehicles()) {
                writer.write(
                        vehicle.getVin() + "|" +
                                vehicle.getYear() + "|" +
                                vehicle.getMake() + "|" +
                                vehicle.getModel() + "|" +
                                vehicle.getVehicleType() + "|" +
                                vehicle.getColor() + "|" +
                                vehicle.getOdoMeter() + "|" +
                                vehicle.getPrice()
                );
                writer.newLine();
            }

            writer.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
