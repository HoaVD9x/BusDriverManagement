package busDriverManagement;

import assignment.Assignment;

import java.util.ArrayList;
import java.util.List;

public class AssignmentService {

    private static  final List<Assignment> assignmentList = new ArrayList<>();

    public static void assignment (){
        if (DriverService.isEmptyDriver() || RouteService.isEmptyRoute()){
            System.out.println("can thuc hien them lai xe va tuyen duong truoc khi phan cog lai xe ");
            return;
        }

        System.out.println();
    }
}
