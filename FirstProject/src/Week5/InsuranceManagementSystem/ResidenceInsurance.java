package Week5.InsuranceManagementSystem;

import java.time.Duration;
import java.time.LocalDate;

public class ResidenceInsurance extends Insurance{
    ResidenceInsurance(String name, double dailyPrice, LocalDate startDate, LocalDate endDate) {
        super(name, dailyPrice, startDate, endDate);
    }

    @Override
    public double calculateFinalPrice() {
        Duration diff = Duration.between(getStartDate(), getEndDate());
        long diffDays = diff.toDays();
        return diffDays * getDailyPrice();
    }
}
