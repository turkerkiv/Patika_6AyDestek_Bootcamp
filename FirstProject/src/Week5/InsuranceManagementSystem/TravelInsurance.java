package Week5.InsuranceManagementSystem;

import java.time.Duration;
import java.time.LocalDate;

public class TravelInsurance extends Insurance{
    TravelInsurance(String name, double dailyPrice, LocalDate startDate, LocalDate endDate) {
        super(name, dailyPrice, startDate, endDate);
    }

    @Override
    public double calculateFinalPrice() {
        Duration diff = Duration.between(getStartDate(), getEndDate());
        long diffDays = diff.toDays();
        return diffDays * getDailyPrice();
    }
}
