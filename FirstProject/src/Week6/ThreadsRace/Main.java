package Week6.ThreadsRace;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i <= 10000; i++)
        {
            numbers.add(i);
        }

        NumFinder numFinder = new NumFinder(numbers);
        Thread[] threads = new Thread[]{new Thread(numFinder), new Thread(numFinder), new Thread(numFinder), new Thread(numFinder)};
        for(Thread t : threads)
        {
            t.start();
        }

        Thread.sleep(5000);
        
        System.out.println(numFinder.getEvens());
        System.out.println(numFinder.getOdds());
    }
}
