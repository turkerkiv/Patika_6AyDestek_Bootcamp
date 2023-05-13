package Week1;
import java.util.Scanner;
public class GcdLcmFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int firstNum = input.nextInt();
        System.out.print("Enter second number: ");
        int secondNum = input.nextInt();

        int gcd = 0;
        for(int i = 1; i < Math.max(firstNum, secondNum); i++)
        {
            if(firstNum % i == 0 && secondNum % i == 0)
            {
                gcd = Math.max(i, gcd);
            }
        }

        int lcm = (firstNum * secondNum) / 2;

        System.out.println("GCD of these two numbers is: " + gcd + "\nLCM of these two numbers is: " + lcm);
    }
}
