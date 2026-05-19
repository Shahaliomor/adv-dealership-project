package com.pluralsight;

public class LeaseContract extends Contract {

    final double LEASE_FEE_RATE = 0.07;
    final double ENDING_VALUE_RATE = 0.50;

    public LeaseContract(String date,
                         String customerName,
                         String customerEmail,
                         Vehicle vehicleSold) {

        super(date, customerName, customerEmail, vehicleSold);
    }

    @Override
    public double getTotalPrice() {

        double price = getVehicleSold().getPrice();

        double endingValue = price * ENDING_VALUE_RATE;

        double leaseFee = price * LEASE_FEE_RATE;

        return endingValue + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {

        double totalPrice = getTotalPrice();

        double monthlyRate = .04 / 12;

        int months = 36;

        return totalPrice *
                ((monthlyRate * Math.pow(1 + monthlyRate, months))
                        /(Math.pow(1 + monthlyRate, months) - 1));
    }
}