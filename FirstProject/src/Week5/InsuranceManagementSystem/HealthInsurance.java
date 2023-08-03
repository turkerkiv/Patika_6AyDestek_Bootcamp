package Week5.InsuranceManagementSystem;

import java.util.Date;

public class HealthInsurance extends Insurance{
    HealthInsurance(String name, double price, Date startDate, Date endDate) {
        super(name, price, startDate, endDate);
    }

    @Override
    public void calculate() {
    //todo
    }
}
