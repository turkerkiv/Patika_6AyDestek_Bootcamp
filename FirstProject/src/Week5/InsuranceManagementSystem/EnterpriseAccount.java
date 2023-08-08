package Week5.InsuranceManagementSystem;

public class EnterpriseAccount extends Account{
    private double discountRate;

    public EnterpriseAccount(User user, double discountRate) {
        super(user);
        this.discountRate = discountRate;
    }

    @Override
    public void addInsurance(Insurance i) {
        i.setFinalPrice(i.calculateDefaultPrice() * discountRate);
        getActiveInsurances().add(i);
    }
}
