package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ContractFileManager {

    public static void saveContract(Contract contract) {

        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("src/main/resources/contracts.csv", true)
            );

            Vehicle vehicle = contract.getVehicleSold();

            if (contract instanceof SalesContract) {

                SalesContract sale = (SalesContract) contract;

                writer.write(
                        "SALE|" +
                                contract.getDate() + "|" +
                                contract.getCustomerName() + "|" +
                                contract.getCustomerEmail() + "|" +
                                vehicle.getVin() + "|" +
                                vehicle.getYear() + "|" +
                                vehicle.getMake() + "|" +
                                vehicle.getModel() + "|" +
                                vehicle.getVehicleType() + "|" +
                                vehicle.getColor() + "|" +
                                vehicle.getOdoMeter() + "|" +
                                vehicle.getPrice() + "|" +
                                contract.getTotalPrice() + "|" +
                                sale.isFinance() + "|" +
                                contract.getMonthlyPayment()
                );

            } else if (contract instanceof LeaseContract) {

                writer.write(
                        "LEASE|" +
                                contract.getDate() + "|" +
                                contract.getCustomerName() + "|" +
                                contract.getCustomerEmail() + "|" +
                                vehicle.getVin() + "|" +
                                vehicle.getYear() + "|" +
                                vehicle.getMake() + "|" +
                                vehicle.getModel() + "|" +
                                vehicle.getVehicleType() + "|" +
                                vehicle.getColor() + "|" +
                                vehicle.getOdoMeter() + "|" +
                                vehicle.getPrice() + "|" +
                                contract.getTotalPrice() + "|" +
                                contract.getMonthlyPayment()
                );
            }

            writer.newLine();
            writer.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}