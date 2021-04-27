import java.util.Scanner;

public class WaterBill {

    public static double calculateWaterBill(double gallonsUsage) {
        return 0;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many gallons of water " +
                "did you use this month?");
        double usage = scanner.nextDouble();
        System.out.println("Your water bill is " +
                calculateWaterBill(usage));
    }
}
