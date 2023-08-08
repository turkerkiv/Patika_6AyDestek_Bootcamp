package Week5.InsuranceManagementSystem;

public class IndividualAccount extends Account{

    public IndividualAccount(User user) {
        super(user);
    }

    @Override
    public void addInsurance(Insurance i) {
        i.setFinalPrice(i.calculateDefaultPrice());
        getActiveInsurances().add(i);
    }
}
