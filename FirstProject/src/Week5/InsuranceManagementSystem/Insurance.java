package Week5.InsuranceManagementSystem;

import java.time.LocalDate;

public abstract class Insurance {
    private String name;
    private double dailyPrice;
    private LocalDate startDate;
    private LocalDate endDate;

    Insurance(String name, double dailyPrice, LocalDate startDate, LocalDate endDate)
    {
        this.name = name;
        this.dailyPrice = dailyPrice;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public abstract double calculateFinalPrice();
}
