package Week2;
import java.util.Scanner;

public class AdvancedCalculator {

    static void Add(Scanner input) {
        int number, result = 0, i = 1;
        while (true) {
            System.out.print(i++ + ". number:");
            number = input.nextInt();
            if (number == 0) {
                break;
            }
            result += number;
        }
        System.out.println("Result: " + result);
    }

    static void Subtract(Scanner input) {
        System.out.print("How many numbers you wanna enter:");
        int counter = input.nextInt();
        int number, result = 0;

        for (int i = 1; i <= counter; i++) {
            System.out.print(i + ". number:");
            number = input.nextInt();
            if (i == 1) {
                result += number;
                continue;
            }
            result -= number;
        }

        System.out.println("Result: " + result);
    }

    static void Multiply(Scanner input) {
        int number, result = 1, i = 1;

        while (true) {
            System.out.print(i++ + ". number:");
            number = input.nextInt();

            if (number == 1)
                break;

            if (number == 0) {
                result = 0;
                break;
            }
            result *= number;
        }

        System.out.println("Result: " + result);
    }

    static void Divide(Scanner input) {
        System.out.print("How many numbers you wanna enter:");
        int counter = input.nextInt();
        double number, result = 0.0;

        for (int i = 1; i <= counter; i++) {
            System.out.print(i + ". number:");
            number = input.nextDouble();
            if (i != 1 && number == 0) {
                System.out.println("Cannot enter 0.");
                continue;
            }
            if (i == 1) {
                result = number;
                continue;
            }
            result /= number;
        }

        System.out.println("Result: " + result);
    }

    static void Power(Scanner input) {
        System.out.print("Enter base number:");
        int base = input.nextInt();
        System.out.print("Enter power:");
        int exponent = input.nextInt();
        int result = 1;

        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }

        System.out.println("Result: " + result);
    }

    static void Factorial(Scanner input) {
        System.out.print("Enter a number:");
        int n = input.nextInt();
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        System.out.println("Result: " + result);
    }

    static void Mod(Scanner input)
    {
        System.out.print("Enter first number: ");
        int numA = input.nextInt();
        System.out.print("Enter second number: ");
        int numB = input.nextInt();

        int mod = numA % numB;
        System.out.println("Mod of these: " + mod);
    }

    static void AreaPerimeterRectangle(Scanner input)
    {
        System.out.print("Enter short side of rectangle: ");
        int shortSide = input.nextInt();
        System.out.print("Enter long side of rectangle: ");
        int longSide = input.nextInt();

        int area = shortSide * longSide;
        int perimeter = shortSide * 2 + longSide * 2;

        System.out.println("Area of this rectangle is: " + area + " and perimeter is: " + perimeter);
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int select;
        String menu = """
                1- Addition
                2- Subtraction
                3- Multiplication
                4- Division
                5- Exponential number
                6- Factorial number
                7- Mod
                8- Area and perimeter of rectangle
                0- Exit""";

        do {
            System.out.println(menu);
            System.out.print("Please select an option:");
            select = input.nextInt();
            switch (select) {
                case 1:
                    Add(input);
                    break;
                case 2:
                    Subtract(input);
                    break;
                case 3:
                    Multiply(input);
                    break;
                case 4:
                    Divide(input);
                    break;
                case 5:
                    Power(input);
                    break;
                case 6:
                    Factorial(input);
                    break;
                case 7:
                    Mod(input);
                    break;
                case 8:
                    AreaPerimeterRectangle(input);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("You entered wrong value. Please retry.");
            }
        } while (select != 0);


    }
}