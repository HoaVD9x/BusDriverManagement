package busDriverManagement;

import route.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RouteService {

    public  static List<Route> routeList = new ArrayList<>();

    public static  void  inputNewRoute (){

        System.out.println(" xin moi nhap cac tuyen duong ban muon them : ");

        int routeNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < routeNumber; i++) {
            Route route = new Route();
            route.inputInfo();
            routeList.add(route);
        }
    }

    public  static  void  showRoute (){
        for (Route route:routeList
             ) {
            System.out.println(route);

        }
    }
    public static boolean isEmptyRoute (){
        for (int i = 0; i < routeList.size(); i++) {
            if (routeList.get(i) != null){
                return false;
            }
        }
        return true;
    }
}
