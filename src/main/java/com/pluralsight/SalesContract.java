package com.pluralsight;

public class SalesContract extends Contract{
    private boolean finance;
    final double SalesTaxAmount=0.05;
    final double recordingFee=100;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean finance){
        super(date,customerName,customerEmail,vehicleSold);
        this.finance=finance;
    }

    public boolean isFinance() {
        return finance;
    }

    @Override
    public double getTotalPrice(){
        double price=getVehicleSold().getPrice();
        double processingFee;
        double total=0;
        if(price<10000){
            processingFee = 295;
        }
        else {
            processingFee = 495;
        }
        total=price+(price*SalesTaxAmount)+recordingFee+processingFee;


        return total;
    }

    @Override
    public double getMonthlyPayment() {

        if (!finance) {
            return 0;
        }

        double totalPrice = getTotalPrice();
        double monthlyRate;
        int months;

        if (totalPrice >= 10000) {
            monthlyRate = 0.0425 / 12;
            months = 48;
        } else {
            monthlyRate = 0.0525 / 12;
            months = 24;
        }

        return totalPrice *
                ((monthlyRate * Math.pow(1 + monthlyRate, months)) /
                        (Math.pow(1 + monthlyRate, months) - 1));
    }





}
