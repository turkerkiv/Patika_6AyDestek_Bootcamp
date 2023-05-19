package Week2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RepeatedNumFinder {
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);
        int[] arr = new int[5];
        List<Integer> repeatedNumsList = new ArrayList<>();

        //Generating random array to find repeated even numbers from
        for(int i = 1; i <= 5; i++)
        {
            arr[i - 1] = (int) (Math.round(Math.random() * 5) * i);
        }

        System.out.println("Random array is: " + Arrays.toString(arr));

        //for each number in array
        for (int j : arr) {
            //if not even number or already added to the repeatedNumsList then pass this turn
            if (j % 2 != 0 || isAlreadyAdded(repeatedNumsList, j)) continue;

            //checking for if repeated
            int repeatCount = 0;
            for (int k : arr) {
                if (j == k) {
                    repeatCount++;
                }
            }
            if (repeatCount > 1) repeatedNumsList.add(j);
        }

        System.out.print("Repeated even numbers: " + repeatedNumsList);
    }

    static boolean isAlreadyAdded(List<Integer> targetList, int num)
    {
        for (int j : targetList) {
            if (num == j) {
                return true;
            }
        }
        return false;
    }
}
