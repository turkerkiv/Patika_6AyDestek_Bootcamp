package Week6.ThreadsRace;

import java.util.ArrayList;
import java.util.List;

public class NumFinder implements Runnable{
    private List<Integer> numsToCheck;
    private List<Integer> odds = new ArrayList<>();
    private List<Integer> evens = new ArrayList<>();
    private int indexToStart = -2500;
    private int indexToEnd = 0;

    public NumFinder(List<Integer> numsToCheck)
    {
        this.numsToCheck = numsToCheck;
    }

    public List<Integer> getOdds() {
        return odds;
    }

    public List<Integer> getEvens() {
        return evens;
    }

    @Override
    public void run() {
        indexToStart += 2500;
        indexToEnd += 2500;
        findNums();
    }

    public synchronized void findNums()
    {
        for(int i = indexToStart; i < indexToEnd; i++)
        {
            int num = numsToCheck.get(i);
            List<Integer> listToAdd = num % 2 == 0 ? evens : odds;
            listToAdd.add(num);
        }
    }
}
