package busDriverManagement;

import driver.Driver;
import mainBusDriverManagent.Main;
import route.Route;

import java.util.Scanner;

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

    public static  void busDriverManage (){
        if (DriverService.isEmptyDriver() || RouteService.isEmptyRoute()){
            System.out.println("ban can them lai xe va tuyen duong");

        }
        System.out.println("nhap so luong lai xe ban muon phan cong vao : ");
        int driverNumber = new Scanner(System.in).nextInt();

        for (int i = 0; i < driverNumber; i++) {

            // them n lai xe vao
            Driver drivers = inputDriverInfo(i);

            // them n tuyen duong ma ban muon them vao
            Route route = inputRouteInfo();


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

        Route route1 = null;
        do {
            int routeNumber = new Scanner(System.in).nextInt();
            if (routeNumber >= 0 && routeNumber <= 15){
            for (int i = 0; i < routeNumber; i++) {
                System.out.println("nhap vao ma tuyen duong :");
                int routeId = new Scanner(System.in).nextInt();
                if (RouteService.routeList.get(i) != null && RouteService.routeList.get(i).getRoute_ID() == routeId){
                    route1 = RouteService.routeList.get(i);
                    break;

                } else {
                    System.out.println("xin vui long nhap lai ");
                }

                System.out.println("vui long nhap khoang cach di chuyen : ");
                int distance = new Scanner(System.in).nextInt();
                System.out.println("vui long nhap so diem dung trong quang duong tren : ");
                int numberOfBusStop = new Scanner(System.in).nextInt();
                RouteService.routeList.add(new Route());

            }} else {
                System.out.println(" xin vui long nhap lai so luong tuyen duong");
            }
        }while (true);
    }

    public static void showBusDriverManagement (){
        for (BusDriverManagement busDriverManagement: Main.busDriverManagementList
             ) {
            System.out.println(busDriverManagement);
        }
    }


}
