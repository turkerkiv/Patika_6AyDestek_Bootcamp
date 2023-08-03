package Week5.InsuranceManagementSystem;

import java.time.Duration;
import java.time.LocalDate;

public class CarInsurance extends Insurance{
    CarInsurance(String name, double dailyPrice, LocalDate startDate, LocalDate endDate) {
        super(name, dailyPrice, startDate, endDate);
    }

    @Override
    public double calculateDefaultPrice() {
        Duration diff = Duration.between(getStartDate(), getEndDate());
        long diffDays = diff.toDays();
        return diffDays * getDailyPrice();
    }
}
