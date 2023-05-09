package Week1;

import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the first number: ");
        int n1 = input.nextInt();
        System.out.print("Please enter the second number: ");
        int n2 = input.nextInt();

        System.out.print("Select the operation: (1)Add (2)Subtract (3)Multiply (4)Divide");
        int choice = input.nextInt();

        switch (choice){
            case 1:
                System.out.println("Sum of these: " + (n1 + n2));
                break;
            case 2:
                System.out.println("Result of subtracting: " + (n1 - n2));
                break;
            case 3:
                System.out.println("Result of multiplication: " + (n1 * n2));
                break;
            case 4:
                System.out.println("Result of division: " + (n1 / n2));
                break;
            default:
                System.out.println("Please restart the app");
                break;
        }
    }
}
