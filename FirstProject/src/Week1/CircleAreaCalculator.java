package Week1;

import java.util.Scanner;

public class CircleAreaCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the radius of circle: ");
        float radius = input.nextInt();
        System.out.print("Please enter the angle of zone: ");
        float a = input.nextInt();
        double areaOfCircle = Math.PI * radius * radius;
        double perimeterOfCircle = 2 * Math.PI * radius;
        double zoneArea = (Math.PI * (radius * radius) * a) / 360;
        System.out.println("Area of Circle: " + areaOfCircle + " perimeter of circle: " + perimeterOfCircle + " area of zone: " + zoneArea);
    }
}
