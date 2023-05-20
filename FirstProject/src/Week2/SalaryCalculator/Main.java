package Week2.SalaryCalculator;

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Türker", 8500, 48, 2001);

        int tax = emp1.calculateTax(emp1.salary);
        int bonus = emp1.calculateBonus(70);
        int raiseAmount = emp1.calculateRaiseAmount(8500, 2001);

        System.out.println("Name: " + emp1.name);
        System.out.println("Salary: " + emp1.salary);
        System.out.println("Weekly work hours: " + emp1.workHours);
        System.out.println("Hire year: " + emp1.hireYear);
        System.out.println("Tax: " + tax);
        System.out.println("Bonus: " + bonus);
        System.out.println("Salary raise amount: " + raiseAmount);
        System.out.println("New salary: " + (emp1.salary + bonus + raiseAmount - tax));
    }
}
