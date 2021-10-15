import java.util.Scanner;

public class PasswordComplexity {

    public static boolean isPasswordComplex(String password) {
       System.out.println(password.length());
       System.out.println(password.matches(".*\\d*."));
       System.out.println(password.matches(".*a-z*."));
       System.out.println(password.matches(".*A-Z*."));
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
