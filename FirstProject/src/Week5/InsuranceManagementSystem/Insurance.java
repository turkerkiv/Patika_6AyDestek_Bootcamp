package Week5.InsuranceManagementSystem;

import java.util.Date;

public abstract class Insurance {
    private String name;
    private double price;
    private Date startDate;
    private Date endDate;

    Insurance(String name, double price, Date startDate, Date endDate)
    {
        this.name = name;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public abstract void calculate();
}
