package busDriverManagement;

import driver.Driver;
import mainBusDriverManagent.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DriverService {
    public static List<Driver> driverList = new ArrayList<>();

    public static void inputNewDriver() {

        System.out.println(" xin nhap so luong lai xe ban muon them vao : ");
        int drivernumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < drivernumber; i++) {
            Driver driver = new Driver();
            driver.inputInfo();

            driverList.add(driver);

        }
    }

    public static void showDriver() {
        for (Driver driver : driverList
        ) {
            System.out.println(driver);

        }
    }

    public static boolean isEmptyDriver() {
        for (int i = 0; i < driverList.size(); i++) {
            if (driverList.get(i) != null) {
                return false;
            }
        }
        return true;
    }


}
