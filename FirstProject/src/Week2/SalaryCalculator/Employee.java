package Week2.SalaryCalculator;

public class Employee {
    String name;
    int salary;
    int workHours;
    int hireYear;

    public Employee(String name, int salary, int workHours, int hireYear){
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public int calculateTax(int salary)
    {
        if(salary > 1000)
        {
            return Math.round(salary * (3f/100f));
        }
        return 0;
    }

    public int calculateBonus(int workHours)
    {
        return 30 * (workHours > 40 ? workHours - 40: 0);
    }

    public int calculateRaiseAmount(int salary, int hireYear)
    {
        int activeYears = 2023 - hireYear;
        if(activeYears < 10)
        {
            return Math.round(salary * (5f/100f));
        }
        else if(activeYears < 20)
        {
            return Math.round(salary * (10f/100f));
        }
        else {
            return Math.round(salary * (15f/100f));
        }
    }
}
