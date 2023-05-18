package Week2;
import java.util.Scanner;
import java.util.Arrays;

public class CloseNumFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] numbers = {1313,43,4,15,35,46,1,341,134,3415};
        System.out.println(Arrays.toString(numbers));

        System.out.print("Enter a number to find closest ones from list: ");
        int inpNum = input.nextInt();

        //FINDING SMALLER CLOSEST
        int smallerClosest = 0;
        int tempGap = Integer.MAX_VALUE;
        for(int i = 0; i < numbers.length; i++)
        {
            int currentGap = Math.abs(numbers[i] - inpNum);
            if(numbers[i] < inpNum && currentGap < tempGap)
            {
                tempGap = currentGap;
                smallerClosest = numbers[i];
            }
        }
        System.out.println("Closest number that smaller than your input is: " + smallerClosest);

        //FINDING GREATER CLOSEST
        int greaterClosest = 0;
        tempGap = Integer.MAX_VALUE;
        for(int i = 0; i < numbers.length; i++)
        {
            int currentGap = Math.abs(numbers[i] - inpNum);
            if(numbers[i] > inpNum && currentGap < tempGap)
            {
                tempGap = currentGap;
                greaterClosest = numbers[i];
            }
        }
        System.out.println("Closest number that greater than your input is: " + greaterClosest);

    }
}
