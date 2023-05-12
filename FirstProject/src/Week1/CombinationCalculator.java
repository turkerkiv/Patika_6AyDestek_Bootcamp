package Week1;
import java.util.Scanner;

public class CombinationCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number that you wanna find combinations from: ");
        int memberCount = input.nextInt();
        System.out.print("Enter each combination's length: ");
        int selectionCount = input.nextInt();

        int facOfMemberCount = 1;
        for(int i = 1; i <= memberCount; i++)
        {
            facOfMemberCount *= i;
        }

        int facOfSelectionCount = 1;
        for (int i = 1; i <= selectionCount; i++)
        {
            facOfSelectionCount *= i;
        }

        int facOfDifference = 1;
        for(int i = 1; i <= memberCount - selectionCount; i++)
        {
            facOfDifference *= i;
        }

        int combinationCount = facOfMemberCount / (facOfSelectionCount * facOfDifference);

        System.out.println("Combination count: " + combinationCount);
    }
}
