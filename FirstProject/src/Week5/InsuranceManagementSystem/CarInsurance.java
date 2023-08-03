package Week5.InsuranceManagementSystem;

import java.util.Date;

public class CarInsurance extends Insurance{
    CarInsurance(String name, double price, Date startDate, Date endDate) {
        super(name, price, startDate, endDate);
    }

    @Override
    public void calculate() {
    //todo
    }
}
