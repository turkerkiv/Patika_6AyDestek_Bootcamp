package Week2;

import java.util.ArrayList;
import java.util.List;

public class NumRepeatCountLister {
    public static void main(String[] args) {
        int[] numbers = {5, 5, 10, 50, 50, 50, 5, 1, 0};
        List<Integer> uniqueNums = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++)
        {
            if(uniqueNums.contains(numbers[i])) continue;
            uniqueNums.add(numbers[i]);

            int repeatCount = 0;
            for(int j = 0; j < numbers.length; j++)
            {
                if(numbers[i] == numbers[j])
                {
                    repeatCount++;
                }
            }
            System.out.println(numbers[i] + " repeated " + repeatCount + " times.");
        }
    }
}
