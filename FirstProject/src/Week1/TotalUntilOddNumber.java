package Week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TotalUntilOddNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int total = 0;
        int num = 0;

        do
        {
            System.out.print("Enter a even number: ");
            num = input.nextInt();

            if(num % 4 == 0)
            {
                total += num;
            }
        }while(num % 2 == 0);

        System.out.print("Total of numbers: " + total);
    }
}
