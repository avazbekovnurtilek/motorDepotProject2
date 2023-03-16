package com.peaksoft;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

import static com.peaksoft.Main.GSON;

public class Truck {
    private int id;
    private String truckName;
    private Driver driver;
    private Status status;

    public static Truck Trucking (int id, String truckName, Driver driver, Status status){
        Truck truck = new Truck();
        truck.id = id;
        truck.truckName = truckName;
        truck.driver = driver;
        truck.status = status;
        return truck;

    }
    public static void write(String truck) {
        Path path = Paths.get(Main.URL);
        try {
            Files.writeString(path, truck, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readFiles(String truck) {

        try {
            FileReader fileReader = new FileReader(Main.URL);
            Scanner scan = new Scanner(fileReader);
            while (scan.hasNext()) {
                System.out.println(scan.nextLine());
            }
        } catch (IOException r) {
            r.printStackTrace();
        }
//    }
//    public static String read(String truck){
//        String json = "";
//        try{
//            FileReader reader = new FileReader(URL);
//            int a;
//            while ((a = reader.read()) != -1){
//                json +=(char)a;
//            }
//            return json;
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return json;
     }
     public static void truckTab(String gson){
        Truck[] trucks = GSON.fromJson(gson,Truck[].class);
         System.out.println("# | Truck   | Driver | status ");
         System.out.println("--+---------+--------+---------");
         for (Truck truck : trucks) {
             System.out.println(truck);
         }
     }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTruckName() {
        return truckName;
    }

    public void setTruckName(String truckName) {
        this.truckName = truckName;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return id +" |  "+truckName+"|"+ driver+ " | "     +status;
    }
}

