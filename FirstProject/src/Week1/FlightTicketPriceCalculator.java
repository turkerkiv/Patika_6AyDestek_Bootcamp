package Week1;

import java.util.Scanner;

public class FlightTicketPriceCalculator {
    public static void main(String[] args) {

        final double FEE_PER_KM = 0.10;

        Scanner input = new Scanner(System.in);

        int age = 1;
        do {
            if(age <= 0 ) System.out.println("You entered incorrect data!");
            System.out.print("Enter your age: ");
            age = input.nextInt();
        }
        while(age < 0);

        int distance = 1;
        do {
            if(distance <= 0 ) System.out.println("You entered incorrect data!");
            System.out.print("Enter distance you wanna flight as kilometer: ");
            distance = input.nextInt();
        }while(distance <= 0);

        System.out.print("Enter type of ticket (1)One Way, (2)Return: ");
        boolean isReturnTicket = input.nextInt() == 2;

        double totalPrice = distance * FEE_PER_KM;

        if(age < 12)
        {
            totalPrice -= totalPrice * 0.5;
        }
        else if(age < 24)
        {
            totalPrice -= totalPrice * 0.1;
        }
        else if(age >= 65)
        {
            totalPrice -= totalPrice * 0.3;
        }

        if(isReturnTicket) totalPrice -= totalPrice * 0.2;

        System.out.println("Total price: " + totalPrice);
    }
}
