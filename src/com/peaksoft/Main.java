package com.peaksoft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Scanner;

public class Main {
    public static GsonBuilder GSON_BUILDER = new GsonBuilder();
    public static Gson GSON = GSON_BUILDER.setPrettyPrinting().create();
    public static String URL = "./gson.truck";
    public static String URL2 = "./gson.driver";

    public static void main(String[] args) {

        Truck[] trucks = new Truck[]{
                Truck.Trucking(1, "Renault", new Driver(), Status.BASE),
                Truck.Trucking(2, "volvo  ", new Driver(), Status.BASE),
                Truck.Trucking(3, "DAF    ", new Driver(), Status.BASE),
        };

        Driver[] drivers = new Driver[]{
                Driver.driverTruck(1, "Putin ", " "),
                Driver.driverTruck(2, "Trump ", " "),
                Driver.driverTruck(3, "Baiden", " "),
        };


        String gson = GSON.toJson(trucks);
//        Truck.write(gson);
//        Truck.readFiles(URL);
        Truck.truckTab(gson);

        System.out.println("-------------------------------------------");

        String gson1 = GSON.toJson(drivers);
        Driver.driverTab(gson1);

        Scanner scan = new Scanner(System.in);

        System.out.println(" Выберите Трак :");
        int count = scan.nextInt();
        TruckService.changeTruck(trucks,drivers,count);




//        Truck[] trucks1 = GSON.fromJson(gson,Truck[].class);
//        for (Truck truck : trucks1){
//            System.out.println(truck);
//        }

//        String gson1 = GSON.toJson(drivers);
//        Driver.driverTab(gson1);

//        Driver.write(gson1);
//        Driver.readFiles(URL2);
//        Driver[] drivers1 = GSON.fromJson(gson1,Driver[].class);
//        for (Driver driver : drivers1){
//            System.out.println(driver);
//        }

//        System.out.println("Добро пожаловать в автопарк : ");
//        TruckService.autoPark();
//        Scanner scan = new Scanner(System.in);
//        int menuNum = scan.nextInt();
//        while (true) {
//            if (menuNum == 1) {
//
//            } else if (menuNum == 2) {
//
//            } else if (menuNum == 3) {
//
//            } else if (menuNum == 4) {
//
//            } else if (menuNum == 0) {
//                System.exit(0);
//            }
//            System.out.println("Выберите номер меню : ");
//            menuNum = scan.nextInt();
//        }

    }
}