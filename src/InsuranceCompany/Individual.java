package InsuranceCompany;

public class Individual extends Account {

    public Individual(User user) {
        super(user);
    }


    @Override
    public void addInsurance(Insurance insurance) {
        getInsurances().add(insurance);
    }

    @Override
    public void showUserInfo() {

    }


}
