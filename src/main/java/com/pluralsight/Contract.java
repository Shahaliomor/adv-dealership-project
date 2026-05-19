package com.pluralsight;

public abstract class Contract {
    private String date;
    private String customerName;
    private String cusromerEmail;
    private Vehicle vehicleSold;

    public Contract(String date, String customerName, String cusromerEmail,Vehicle vehicleSold ) {
        this.date = date;
        this.customerName = customerName;
        this.cusromerEmail = cusromerEmail;
        this.vehicleSold = vehicleSold;
    }

    public String getDate() {
        return date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCusromerEmail() {
        return cusromerEmail;
    }

    public abstract double getTotalPrice();
    public abstract double getMonthlyPayment();
}
