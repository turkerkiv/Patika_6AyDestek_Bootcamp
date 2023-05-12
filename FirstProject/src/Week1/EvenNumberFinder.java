package Week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class EvenNumberFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter a number to find even numbers until that number: ");
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
