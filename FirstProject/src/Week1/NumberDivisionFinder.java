package Week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class NumberDivisionFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter a number to find numbers that can be divided by 3 and 4 until that number: ");
        int number = input.nextInt();

        List<Integer> evenNumbers = new ArrayList<>();

        for(int i = 1; i <= number; i++)
        {
            if(i % 3 ==0 && i % 4 == 0)
            {
                evenNumbers.add(i);
            }
        }

        System.out.print(evenNumbers);
    }
}
