package Week1;

import java.util.Scanner;

public class LeapYearFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter a year to find if it is leap year: ");
        int year = input.nextInt();

        if(year % 100 == 0 && year % 400 == 0)
        {
            System.out.println(year + " is leap year.");
        }
        if(year % 4 == 0)
        {
            System.out.println(year + " is leap year.");
        }
        else {
            System.out.println(year + " is not leap year.");
        }

    }
}
