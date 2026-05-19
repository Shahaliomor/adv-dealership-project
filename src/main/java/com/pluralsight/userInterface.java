package com.pluralsight;

import java.util.Scanner;

public class userInterface {
    Dealership dealership;
    public static Scanner input=new Scanner(System.in);
    public void display() {


        for (int i = 0; i < dealership.getAllVehicles().size(); i++) {
            Vehicle vehicle = dealership.getAllVehicles().get(i);
            print(vehicle);
        }
    }
    public void userInterface(){
        init();
        while (true){
            System.out.println("""
                1 - Find vehicles within a price range
                2 - Find vehicles by make / model
                3 - Find vehicles by year range
                4 - Find vehicles by color
                5 - Find vehicles by mileage range
                6 - Find vehicles by type (car, truck, SUV, van)
                7 - List ALL vehicles
                8 - Add a vehicle
                9 - Remove a vehicle
                99 - Quit
                """);
            System.out.println("please choose: ");
            int choose=input.nextInt();
            if(choose==1){
                getByPriceRequest();

            }else if (choose==2) {
                getByMakeModelRequest();
            } else if (choose==3) {
                getByYearRequest();

            } else if (choose==4) {
                getByColorRequest();

            } else if (choose==5) {
                getByMileageRequest();

            } else if (choose==6) {
                getByVehicleTypeRequest();

            } else if (choose==7) {
                GetAllVehicleRequest();
            } else if (choose==8) {
                addVehicleRequest();

            } else if (choose==9) {
                removeVehicleRequest();

            } else if (choose==99) {
                break;
            }

        }
    }

    public void init () {
        dealership = DealershipFileManager.getDealership();
    }

    public void getByPriceRequest(){

        System.out.println("what is the price range: ");
        System.out.print("minimum: ");
        double min=input.nextDouble();
        System.out.print("maximum: ");
        double max=input.nextDouble();

        for (int i = 0; i < dealership.getAllVehicles().size(); i++) {
            Vehicle vehicle = dealership.getAllVehicles().get(i);
            if(vehicle.getPrice()>=min && vehicle.getPrice()<=max)
            {
                print(vehicle);
            }
        }
    }

    public void getByMakeModelRequest(){

        input.nextLine();

        System.out.println("Make: ");
        String make=input.nextLine();

        System.out.print("model: ");
        String model=input.nextLine();

        for (int i = 0; i < dealership.getAllVehicles().size(); i++) {

            Vehicle vehicle = dealership.getAllVehicles().get(i);

            if(vehicle.getMake().equalsIgnoreCase(make) ||
                    vehicle.getModel().equalsIgnoreCase(model))
            {
                print(vehicle);
            }
        }
    }
    public void getByYearRequest(){


        System.out.print("year: ");
        double year=input.nextDouble();


        for (int i = 0; i < dealership.getAllVehicles().size(); i++) {
            Vehicle vehicle = dealership.getAllVehicles().get(i);
            if(vehicle.getYear()==year)
            {
                print(vehicle);
            }
        }
    }

    public void getByColorRequest(){

        input.nextLine();
        System.out.print("Color: ");
        String color=input.nextLine();


        for (int i = 0; i < dealership.getAllVehicles().size(); i++) {
            Vehicle vehicle = dealership.getAllVehicles().get(i);
            if(vehicle.getColor().equalsIgnoreCase(color))
            {
                print(vehicle);
            }
        }
    }

    public void getByMileageRequest(){


        System.out.print("Mileage: ");
        int mile=input.nextInt();


        for (int i = 0; i < dealership.getAllVehicles().size(); i++) {
            Vehicle vehicle = dealership.getAllVehicles().get(i);
            if(vehicle.getOdoMeter()==mile)
            {
                print(vehicle);
            }
        }
    }

    public void getByVehicleTypeRequest(){

        input.nextLine();
        System.out.print("Type: ");
        String type=input.nextLine();


        for (int i = 0; i < dealership.getAllVehicles().size(); i++) {
            Vehicle vehicle = dealership.getAllVehicles().get(i);
            if(vehicle.getVehicleType().equalsIgnoreCase(type))
            {
                print(vehicle);
            }
        }
    }

    public void GetAllVehicleRequest () {

        display();
    }
    public void addVehicleRequest(){

        System.out.print("VIN: ");
        int vin=input.nextInt();

        System.out.print("Year: ");
        int year=input.nextInt();

        input.nextLine();

        System.out.print("Make: ");
        String make=input.nextLine();

        System.out.print("Model: ");
        String model=input.nextLine();

        System.out.print("Vehicle Type: ");
        String type=input.nextLine();

        System.out.print("Color: ");
        String color=input.nextLine();

        System.out.print("Mileage: ");
        int odo=input.nextInt();

        System.out.print("Price: ");
        double price=input.nextDouble();

        Vehicle vehicle = new Vehicle(
                vin,
                year,
                make,
                model,
                type,
                color,
                odo,
                price
        );

        dealership.addVehicle(vehicle);
        DealershipFileManager.saveDealership(dealership);
        System.out.println("Vehicle added.");
    }
    public void removeVehicleRequest(){

        System.out.print("Enter VIN to remove: ");
        int vin=input.nextInt();

        for (int i = 0; i < dealership.getAllVehicles().size(); i++) {

            Vehicle vehicle = dealership.getAllVehicles().get(i);

            if(vehicle.getVin()==vin){

                dealership.getAllVehicles().remove(i);
                DealershipFileManager.saveDealership(dealership);
                System.out.println("Vehicle removed.");

                break;
            }
        }
    }


    public void print(Vehicle vehicle){
        System.out.println("--------------------------------");
        System.out.println("VIN: " + vehicle.getVin());
        System.out.println("Year: " + vehicle.getYear());
        System.out.println("Make: " + vehicle.getMake());
        System.out.println("Model: " + vehicle.getModel());
        System.out.println("Type: " + vehicle.getVehicleType());
        System.out.println("Color: " + vehicle.getColor());
        System.out.println("Mileage: " + vehicle.getOdoMeter());
        System.out.println("Price: $" + vehicle.getPrice());
    }
}

