package Week2;
import java.util.Scanner;

public class RecursivePrimeNumFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number to find if it is prime number: ");
        isPrime(input.nextInt(), 2);
    }

    static boolean isPrime(int number, int divisor) {
        if (number <= 2) {
            return (number == 2);
        }

        if (number % divisor == 0) {
            return false;
        }

        if (divisor * divisor > number) {
            return true;
        }

        return isPrime(number, divisor + 1);
    }

}
