package Week1;

import java.util.Scanner;

public class Taximeter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double totalAmount = 30;
        double amountPerKm = 2.20;
        System.out.print("Please enter the kilometer you traveled: ");
        double kilometerTraveled = input.nextInt();

        totalAmount += amountPerKm * kilometerTraveled;
        System.out.print("Total amount is: " + totalAmount);
    }
}
