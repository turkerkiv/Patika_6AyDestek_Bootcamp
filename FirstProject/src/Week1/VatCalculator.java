package Week1;

import java.util.Scanner;

public class VatCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the value of item: ");
        int value = input.nextInt();

        float vat = value >= 1000 ? 8f / 100f : 18f / 100f;
        float valueWithVat = value + (value * vat);

        System.out.print("Vat is: " + value * vat + " Value with vat is: " + valueWithVat);
    }
}
