package Week2.FinalProject101;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MineSweeper {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.print("Enter row count: ");
        int matrixRowCount = inp.nextInt();
        if(matrixRowCount <= 0){
            System.out.println("Please enter a valid size!");
            System.exit(0);
        }

        System.out.print("Enter column count: ");
        int matrixColumnCount = inp.nextInt();
        if(matrixColumnCount <= 0){
            System.out.println("Please enter a valid size!");
            System.exit(0);
        }

        String[][] matrix = new String[matrixRowCount][matrixColumnCount];
        for(int i = 0; i < matrixRowCount; i++)
        {
            for(int j = 0; j < matrixColumnCount; j++)
            {
                matrix[i][j] = " - ";
            }
        }

        //placing random mines into the field
        int totalElementCount = matrixColumnCount * matrixRowCount;
        int mineCount = totalElementCount / 4;
        List<String> minePositions = new ArrayList<>();
        List<String> selectedPositions = new ArrayList<>();

        for(int i = 0; i < mineCount; i++)
        {
            int randomRow = (int)(Math.random() * (matrixRowCount - 1));
            int randomColumn = (int)(Math.random() * (matrixColumnCount - 1));

            while(matrix[randomRow][randomColumn] == "*")
            {
                randomRow = (int)(Math.random() * (matrixRowCount - 1));
                randomColumn = (int)(Math.random() * (matrixColumnCount - 1));
            }

            String pos = randomRow + "-" + randomColumn;
            minePositions.add(pos);
            //matrix[randomRow][randomColumn] = " * ";
        }

        printMatrix(matrix);

        int minelessCount = totalElementCount - mineCount;
        int currentScore = 0;

        //Playing
        while(true) {

            System.out.print("Enter the row of the point you wanna select: ");
            int selectedRow = inp.nextInt();
            if(selectedRow >= matrixRowCount){
                System.out.println("Enter valid point!");
                continue;
            }

            System.out.print("Enter the column of the point you wanna select: ");
            int selectedColumn = inp.nextInt();
            if(selectedColumn >= matrixColumnCount){
                System.out.println("Enter valid point!");
                continue;
            }

            String selectedPos = selectedRow + "-" + selectedColumn;
            if(minePositions.contains(selectedPos))
            {
                System.out.print("You pressed mine. GAME OVER!!!");
                break;
            }
            else {
                if(selectedPositions.contains(selectedPos)) {
                    System.out.println("You already selected this point!!!");
                    continue;
                }
                selectedPositions.add(selectedPos);
                currentScore++;
                System.out.println("Nice. Keep going!");

                //searching mines around the selected point
                int rowStart = selectedRow - 1;
                int columnStart = selectedColumn - 1;
                int rowEnd = selectedRow + 1;
                int columnEnd = selectedColumn + 1;

                int mineCountAround = 0;
                for(int i = rowStart; i <= rowEnd; i++)
                {
                   for(int j = columnStart; j <= columnEnd; j++)
                   {
                       if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[i].length) continue;
                       String currentPos = i + "-" + j;
                       if(minePositions.contains(currentPos))
                        {
                            mineCountAround++;
                        }
                   }
                }

                matrix[selectedRow][selectedColumn] = " " + mineCountAround + " ";
                printMatrix(matrix);

                if(minelessCount == currentScore) {
                    System.out.print("You won the game!!!!!!!!");
                    break;
                }
            }
        }
    }

    static void printMatrix(String[][] matrix)
    {
        //for debugging purposes
        System.out.println("================");

        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[i].length; j++)
            {
                System.out.print(matrix[i][j]);
            }

            System.out.println();
        }

        System.out.println("================");
    }
}
