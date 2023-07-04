package InsuranceCompany;

public class Enterprise extends Account{
    public Enterprise(User user) {
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
