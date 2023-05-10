package Week1;

import java.util.Scanner;

public class ActivityRecommendatory {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the temperature of today as celcius: ");
        int celcius = input.nextInt();

        if (celcius <= 5) System.out.println("My recommendation is skiing");
        else if (celcius > 5 && celcius <= 15) System.out.println("My recommendation is going to the cinema");
        else if (celcius > 15 && celcius <= 25) System.out.println("My recommendation is going to the picnic");
        else System.out.println("My recommendation is swimming");

    }
}
