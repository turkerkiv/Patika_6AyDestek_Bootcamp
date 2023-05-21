package Week2;
import javax.swing.text.html.CSS;
import java.util.Scanner;

public class MatrixTransposeFinder {
    public static void main(String[] args) {
        
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter row count of matrix: ");
        int defaultRowCount = inp.nextInt();
        System.out.print("Enter column count of matrix: ");
        int defaultColumnCount = inp.nextInt();

        //creating default matrix randomly
        int[][] defaultMatrix = new int[defaultRowCount][defaultColumnCount];
        fillMatrixRandomly(defaultMatrix);

        //creating transpose matrix
        int[][] transposeMatrix = new int[defaultColumnCount][defaultRowCount];
        for(int i = 0; i < defaultColumnCount; i++) //using default matrix's column count as row count
        {
            for(int j = 0; j < defaultRowCount; j++) //using default matrix's row count as column count
            {
                transposeMatrix[i][j] = defaultMatrix[j][i];
            }
        }

        System.out.println("Randomly created default matrix: ");
        printMatrix(defaultMatrix);
        System.out.println();
        System.out.println("Transpose matrix: ");
        printMatrix(transposeMatrix);
    }

    static void fillMatrixRandomly(int[][] matrix)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
    }

    static void printMatrix(int[][] matrix)
    {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(ints[j] + "  ");
            }
            System.out.println();
        }
    }
}
