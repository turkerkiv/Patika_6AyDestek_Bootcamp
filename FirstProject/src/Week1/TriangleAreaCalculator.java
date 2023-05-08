package Week1;

import java.util.Scanner;

public class TriangleAreaCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the length of first side: ");
        int firstSide = input.nextInt();
        System.out.print("Enter the length of second side: ");
        int secondSide = input.nextInt();
        System.out.print("Enter the length of third side: ");
        int thirdSide = input.nextInt();

        float perimeter = firstSide + secondSide + thirdSide;
        float s = perimeter / 2f;
        double area = Math.sqrt(s * (s - firstSide) * (s - secondSide) * (s - thirdSide));

        System.out.println("Area of the triangle you gave is: " + area);
    }
}
