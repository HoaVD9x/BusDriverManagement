package busDriverManagement;

import driver.Driver;
import mainBusDriverManagent.Main;
import route.Route;

import java.util.*;

public class BusDriverManagement {

    private Driver driver;

    private Route route;

    public BusDriverManagement(Driver driver, Route route) {
        this.driver = driver;
        this.route = route;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "BusDriverManagement{" +
                "driver=" + driver +
                ", route=" + route +
                '}';
    }

    static List<BusDriverManagement> busDriverManagementList = new ArrayList<>();



    public static  void busDriverManage (){

        System.out.println("nhap so luong lai xe ban muon phan cong vao : ");
        int driverNumber = new Scanner(System.in).nextInt();

        for (int i = 0; i < driverNumber; i++) {

            // them n lai xe vao
            Driver drivers = inputDriverInfo(i);

            // them n tuyen duong ma ban muon them vao
            Route route = inputRouteInfo();
            BusDriverManagement busDriverManagement = new BusDriverManagement(drivers, route);
            busDriverManagementList.add(busDriverManagement);


        }
    }
    public static  Driver inputDriverInfo(int order ){
        System.out.println("nhap ma lai xe thu " + ( order + 1) + " vao");
        Driver driver = null;
        do {
            int driverId = new Scanner(System.in).nextInt();
            for (int i = 0; i < DriverService.driverList.size(); i++) {
                if (DriverService.driverList.get(i) != null && DriverService.driverList.get(i).getDriver_id() == driverId){
                    driver = DriverService.driverList.get(i);
                    break;
                }

            }
            if (driver != null){
                break;
            }
            System.out.println("khong tin thay ma lai xe ban vua nhap");
            System.out.println("xin vui long nhap lai ma lai xe ");
        }while (true);
        return driver;
    }

    public static Route inputRouteInfo(){
        System.out.println("nhap so luong tuyen duong ban muon them vao :");


        do {
            int routeNumber = new Scanner(System.in).nextInt();
            do {
                if (routeNumber >= 0 && routeNumber <= 15){
                    break;
                }
                System.out.println(" hay nhap lai cho dung 1 lai xe chi co the lai duoc 15 chuyen 1 ngay ");
            }while (true);

            for (int i = 0; i < routeNumber; i++) {
                System.out.println("xin moi nhap ma tuyen duong thu :" + (i + 1));
                int routeID = new Scanner(System.in).nextInt();
                do {
                    if (RouteService.routeList.get(i) != null && RouteService.routeList.get(i).getRoute_ID() == routeID){
                        break;
                    }
                    System.out.println("khong tim thay ma tuyen duong ban vua nhap, vui long nhap lai ");
                }while (true);
                System.out.println("tuyen duong vua nhap co co khoang cach la bao nhieu vay : ");
                int distance = new Scanner(System.in).nextInt();
                System.out.println("tuyen duong ban nhap co bao nhieu diem dung :");
                int numberOfBusStop = new Scanner(System.in).nextInt();
                Route route = new Route(routeID,distance,numberOfBusStop);

            }
        }while (true);
    }

    public static void showBusDriverManagement (){
        for (BusDriverManagement busDriverManagement: busDriverManagementList
             ) {
            System.out.println(busDriverManagement);
        }
    }

    public  static  void sortBusDriverManagent (){
        System.out.println(" nhap lua cho cua ban : ");
        System.out.println(" sap xep theo ho ten lai xe ");
        System.out.println(" sap xep theo so luong tuyen giam dan ");
        int choice  = 0;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice == 1 || choice == 2 ){
                break;
            }
            System.out.println("lua chon khong hop le vui long chon lai");
        }while (true);
        switch (choice){
            case 1:
           //   busDriverManagementList.stream().sorted(Comparator.comparing(Driver::getName));

                break;
            case 2:
               Collections.sort(busDriverManagementList, new Comparator<BusDriverManagement>() {

                   @Override
                   public int compare(BusDriverManagement o1, BusDriverManagement o2) {
                       return o1.route.toString().compareTo(o2.toString()) ;
                   }
               });
                showBusDriverManagement ();
                break;

        }
    }


}
