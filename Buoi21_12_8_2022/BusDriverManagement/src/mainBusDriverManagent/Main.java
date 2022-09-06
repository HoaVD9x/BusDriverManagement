package mainBusDriverManagent;

import busDriverManagement.BusDriverManagement;
import busDriverManagement.DriverService;
import busDriverManagement.RouteService;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
       // menu();

        Connection connection = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mariadb:// mariadb-tutorial.clicssmtjld8.ap-northeast-2.rds.amazonaws.com/classicmodels\", \"administrator\", \"6i6Z&9ooKjFK");
            String selectQuery = "select cus.customernumber, cus.customername, cus.phone, cus.country from customers cus";
            String deleteQuery = "DELETE FROM customers WHERE customerNumber=361";
            String insert = "INSERT INTO classicmodels.offices (officeCode,city,phone,addressLine1,addressLine2,state,country,postalCode,territory)\n" +
                    "\tVALUES ('8','Viet nam','+84 089 95 478','Ha Noi','Hoai Duc','CA','HN','100000','NA')";
            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(deleteQuery); // for select
            statement.execute(insert);// for del nad update & insert
            // print with format table
            String leftAlignFormat = "| %-17d | %-29s | %-16s | %-13s |%n";

            System.out.format("+-----------------+---------------------------+---------------+-------------+%n");
            System.out.format("| Customer Number |       Customer Name       |      Phone    |   Country   |%n");
            System.out.format("+-----------------+---------------------------+---------------+-------------+%n");
            /*while (resultSet.next()){ // for select
                System.out.format(leftAlignFormat,
                        resultSet.getInt("customernumber"),
                        resultSet.getString("customername"),
                        resultSet.getString("phone"),
                        resultSet.getString("country"));
                System.out.format("+-----------------+---------------------------+---------------+-------------+%n");
            }*/
            System.out.format("+-----------------+---------------------------+---------------+-------------+%n");


        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            assert connection != null;
            connection.close();

        }
    }



    private static void menu()

    {
        boolean isExit = false;

        do {

            int functionChoice = functionChoice();

            switch (functionChoice) {
                case 1:
                    DriverService.inputNewDriver();
                    break;
                case 2:
                    DriverService.showDriver();
                    break;
                case 3:
                    RouteService.inputNewRoute();
                    break;
                case 4:
                    RouteService.showRoute();
                    break;
                case 5:
                    BusDriverManagement.busDriverManage();
                    BusDriverManagement.showBusDriverManagement();
                    break;
                case 6:
                    BusDriverManagement.sortBusDriverManagent();
                    break;
                case 7:

                    break;
                case 8:
                    break;

            }
        } while (!isExit);
    }

    private static int functionChoice() {
        showMenu();
        System.out.println(" xin moi nhap chuc nang : ");

        int choice;

        do {
             choice = new Scanner(System.in).nextInt();

            if (choice >= 1 && choice <= 8) {
                break;
            } else {
                System.out.println(" lua chon khong hop le, vui long chon lai ");
            }
        } while (true);
        return choice;
    }

    private static void showMenu() {
        System.out.println(" \n\n\n ----- PHAN MEM QUAN LY XE BUS -----");
        System.out.println("1. them  lai xe moi ");
        System.out.println("2. in ra toan bo lai xe ");
        System.out.println("3. them  tuyen xe moi ");
        System.out.println("4. in ra toan bo tuyen xe ");
        System.out.println("5. phan cong lai xe ");
        System.out.println("6. hien thi danh sach phan cong");
        System.out.println("7. hien thi tong khoang cach chay trong ngay cho lai xe ");
        System.out.println("8. thoat ");
    }
}
