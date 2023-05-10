package Week1;

import java.util.Scanner;

public class AscendingSorter {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the number a: ");
        int numberA = input.nextInt();

        System.out.print("Please enter the number b: ");
        int numberB = input.nextInt();

        System.out.print("Please enter the number c: ");
        int numberC = input.nextInt();

        if(numberA > numberB && numberA > numberC) {
            if(numberB > numberC) {
                System.out.println("Ascending order is: " + numberC + " < " + numberB + " < " + numberA);
            }
            else if (numberB < numberC)
            {
                System.out.println("Ascending order is: " + numberB + " < " + numberC + " < " + numberA);
            }
        }
        else if(numberB > numberA && numberB > numberC)
        {
            if(numberA > numberC)
            {
                System.out.println("Ascending order is: " + numberC + " < " + numberA + " < " + numberB);
            }
            else if(numberA < numberC)
            {
                System.out.println("Ascending order is: " + numberA + " < " + numberC + " < " + numberB);
            }
        }
        else if(numberC > numberA && numberC > numberB)
        {
            if(numberA > numberB)
            {
                System.out.println("Ascending order is: " + numberB + " < " + numberA + " < " + numberC);
            }
            else if(numberA < numberB)
            {
                System.out.println("Ascending order is: " + numberA + " < " + numberB + " < " + numberC);
            }
        }
    }
}
