package Week1;
import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number that you wanna get the sum of digits: ");
        int num = input.nextInt();
        char[] numStr = String.valueOf(num).toCharArray();

        int sumOfDigits = 0;
        for (char c : numStr) {
            sumOfDigits += Character.getNumericValue(c);
        }

        System.out.println("Sum of digits: " + sumOfDigits);
    }
}
