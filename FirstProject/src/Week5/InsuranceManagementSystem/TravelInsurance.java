package Week5.InsuranceManagementSystem;

import java.time.LocalDate;
import java.time.Period;

public class TravelInsurance extends Insurance{
    TravelInsurance(double dailyPrice, LocalDate startDate, LocalDate endDate) {
        super("Travel Insurance", dailyPrice, startDate, endDate);
    }

    @Override
    public double calculateDefaultPrice() {
        Period diff = Period.between(getStartDate(), getEndDate());
        long diffMonths = diff.toTotalMonths();
        return diffMonths * 30 * getDailyPrice();
    }
}
