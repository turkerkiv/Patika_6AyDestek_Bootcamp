package Week2;
import java.util.Arrays;
import java.util.Scanner;

public class ArraySorter {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.print("Enter array's size: ");
        int size = inp.nextInt();
        int[] numbers = new int[size];

        System.out.println("Enter numbers: ");
        for(int i = 0; i < size; i++)
        {
            System.out.print((i + 1) + ". number: ");
            int num = inp.nextInt();
            numbers[i] = num;
        }

        int[] sortedArray = new int[size];
        for(int i = 0; i < size; i++)
        {
            int comparisonSucsCount = 0;
            for(int j = 0; j < size; j++)
            {
                if(numbers[i] > numbers[j])
                {
                    comparisonSucsCount++;
                }
            }

            sortedArray[comparisonSucsCount] = numbers[i];
        }

        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
    }
}
