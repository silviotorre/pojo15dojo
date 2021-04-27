import java.util.Scanner;

public class PasswordComplexity {

    public static boolean isPasswordComplex(String password) {
        return true;
    }

    public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);

       System.out.println("Enter a password: ");
       String userInput = scanner.nextLine();
       System.out.println("Is the password complex? " +
               isPasswordComplex(userInput));
    }
}
