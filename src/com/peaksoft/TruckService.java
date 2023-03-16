package com.peaksoft;

import java.util.Random;
import java.util.Scanner;

public class TruckService {
    static String driverName;
    static String dr;
    static String truckName;
    static Driver driver = new Driver();
    static Truck truck = new Truck();
    static Scanner scan = new Scanner(System.in);
    static Random random = new Random();


    public static void autoPark(){
        System.out.println("меню: " +"\n"+
                "1. Выберите авто " +"\n"+
                "2. Выберите водителя " +"\n"+
                "3. Отправить в путь " +"\n"+
                "4. отправить в ремонт " +"\n"+
                "0. выход из прогрраммы! ");
    }
    public static void changeTruck(Truck[] trucks,Driver[] drivers, int id){
        for (Truck truck : trucks){
            if(truck.getDriver().getName() == null){
                dr = " ";
            }else{
                dr = truck.getDriver().getName();
            }
            truck.getDriver().setName(" ");
            if (truck.getId() == id){
                System.out.println("# | TruckName | Driver | status "+"\n"+
                                   "--+-----------+--------+--------"+"\n"+
                        truck.getId()+" |  "+truck.getTruckName()+"  |     "+truck.getDriver().getName()+"  |  "+Status.BASE);
                System.out.println();
                if (truck.getStatus().equals(Status.BASE)){
                    System.out.println("Для отправки трака нажмите: 1");
                    System.out.println("Для отправки в ремонт нажмите: 2");
                    System.out.println("Для выбора водителя, нажмите: 3");
                    System.out.println();

                    int change = scan.nextInt();
                    if (change == 1){
                        randomDriver(drivers);
                        System.out.println("Трак "+truck.getTruckName()+",ведет водитель "+driverName);
                        startDriving(truck.getTruckName(),driverName);
                        truck.setStatus(Status.ROUTE);
                        System.out.println("Успешно вышли на маршрут!");
                        System.out.println();
                        System.out.println("");
                    }
                    if (change == 2){
                        randomDriver(drivers);
                        startRepair(truck.getTruckName(),driverName);
                        System.out.println("Трак отправлен на ремонт!");
                    }
                    if(change == 3){
                        System.out.println("# | Driver | truck \n" +
                                "--+--------+--------\n" +
                                "1 | Putin  |  \n" +
                                "2 | Trump  |  \n" +
                                "3 | Baiden |");
                        System.out.println("Выберите водителя : ");
                        int change1 = scan.nextInt();
                        if (change1 == 1){
                            randomTruck(trucks);
                            // не получатеся добавить рандом !!!!
                            System.out.println("Vladimir Putin "+ truck.getTruckName());
                        } else if (change1 == 2) {
                            System.out.println("Donald Tramp "+ truck.getTruckName());
                        }else {
                            System.out.println("Jоe Baiden "+ truckName);
                        }
                        System.out.println("хотите его отпрвить в путь тогда нажмите 1 если нет то 9 !");
                        // сделал бы дальше надо спросить у Тимур байке!!!
                    }
                    }

                }
            }
            if (driver.getId() == id){
                System.out.println("#: "+ driver.getId());
                System.out.println("Driver: "+ driver.getName());
                System.out.println("Truck: ");

        }
    }
    public static void startDriving(String truckName,String driverName){
        System.out.println("# | Truck   | Driver  | status" +"\n"+
                           "--+---------+---------+-------"+"\n"+
                +driver.getId()+" | " +truckName+" | "+driverName+"  |  "+Status.ROUTE );

    }
    public static void startRepair(String truckName,String driverName){
        System.out.println("# | Truck   | Driver  | status" +"\n"+
                "--+---------+---------+-------"+"\n"+
                +driver.getId()+" | " +truckName+" | "+driverName+"  |  "+Status.REPAIR);
    }
    public static void randomDriver(Driver[] drivers){
        int r = random.nextInt(3)+1;
        for (Driver driver1 : drivers) {
            if (driver1.getId() == r){
                driverName = driver1.getName();
                driver = driver1;
            }
            
        }
    }
    public static void randomTruck(Truck[] trucks){
        int n = random.nextInt(3)+1;
        for (Truck truck1 : trucks){
            if (truck1.getId() == n){
                truckName = truck1.getTruckName();
                truck = truck1;
            }
        }
    }
}