import java.util.List;
import java.util.Map;

public class StudentVolunteers {

    static List<String> findWithIncompleteEvents(
            List<String> students,
            Map<String, List<String>> attendeesMapping) {

        return List.of();
    }

    public static void main(String[] args) {

        List<String> students = List.of("Sally", "Polly", "Molly",
                "Tony", "Harry");

        Map<String, List<String>> attendeesMapping =
                Map.of("Farmer's Market",
                        List.of("Sally", "Polly"),
                        "Car Wash Fundraiser",
                        List.of("Molly", "Tony", "Polly"),
                        "Cooking Workshop",
                        List.of("Sally", "Molly", "Polly"),
                        "Midnight Breakfast",
                        List.of("Polly", "Molly"));

        System.out.println(findWithIncompleteEvents(students,
                attendeesMapping));
    }

}
