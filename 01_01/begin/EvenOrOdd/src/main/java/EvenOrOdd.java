import java.util.Scanner;

public class EvenOrOdd {

   public static boolean isEven(int n) {
      //return n%2==0;// uso del modulo
      //return (n & 1)==0; //bitwise AND (is faster)
      return (n ^ 1) ==n+1; /*
      * bitwise XOR - OR esclusivo con 1 cioè con ...0001  
      * bit per bit cambia l'ultimo bit dove e presente 1
      * (a differenza dell'OR puro).
      *Se il n è dispari,termina in 1 e quindi diventa 0
      *che è il numero pari precedente, viceversa diventa 
      * il numero pari successivo: (n ^ 1) ==n+1 TRUE
      * Avremmo potuto usare anche (n ^ 1) !=n-1 TRUE
      *-------------------------------------
      *Moltiplicare *2 e dividere per due funziona con gli
      *int (che arrotondano) ma impone due passaggi.
      *Il contrario dividere prima e poi moltiplicare è
      *darebbe risultati contrari visto che i dispari 
      *sarebbero arrotondati al numero (dispari) precedente 
      *Quindi per noi è rilevante che:
      *n/2*2==n è TRUE solo se n è pari
      */
   }

   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       System.out.println("Enter a number: ");
       int userNum = scanner.nextInt();
       System.out.println("Is the number even? " + isEven(userNum));
   }
}
