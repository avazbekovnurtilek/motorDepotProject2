package com.peaksoft;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

import static com.peaksoft.Main.GSON;
import static com.peaksoft.Main.URL2;

public class Driver {
    private int id;
    private String name;
    private String truck;

    public static Driver driverTruck (int id, String name,String truck) {
        Driver driver = new Driver();
        driver.id = id;
        driver.name = name;
        driver.truck = truck;
        return driver;
    }
    public static void write(String driver) {
        Path path = Paths.get(URL2);
        try {
            Files.writeString(path, driver, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readFiles (String driver) {

        try {
            FileReader fileReader2 = new FileReader(URL2);
            Scanner scan = new Scanner(fileReader2);
            while (scan.hasNext()) {
                System.out.println(scan.nextLine());
            }
        } catch (IOException r) {
            r.printStackTrace();
        }

    }
    public static void driverTab(String gson1){
        Driver[] drivers = GSON.fromJson(gson1,Driver[].class);
        System.out.println("# | Driver | truck ");
        System.out.println("--+--------+--------");
        for (Driver driver : drivers) {
            System.out.println(driver);
        }
    }
//    public static String read(String driver){
//        String json1 = " ";
//        try{
//            FileReader reader = new FileReader(URL2);
//            int a;
//            while ((a = reader.read()) != -1){
//                json1 += (char) a;
//            }
//            return json1;
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return json1;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTruck() {
        return truck;
    }

    public void setTruck(String truck) {
        this.truck = truck;
    }

    @Override
    public String toString() {
        return infoDriving();
    }
    public String infoDriving(){
        return id+" | " + name + " | " + truck;
    }

}
