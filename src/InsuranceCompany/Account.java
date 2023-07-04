package InsuranceCompany;

import java.util.ArrayList;

abstract class Account implements Comparable<Account> {
    private AuthenticationStatus authenticationStatus;
    private User user;
    private ArrayList<Insurance> insurances;

    public Account(User user) {
        this.authenticationStatus = AuthenticationStatus.FAIL;
        this.user = user;
        this.insurances = new ArrayList<>();
    }

    public void login(String email, String password) throws InvalidAuthenticationException {
        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
            authenticationStatus = AuthenticationStatus.SUCCESS;
        } else {
            throw new InvalidAuthenticationException("Invalid email or password.");
        }
    }

    public void addAddress(Address address) {
        user.getAddresses().add(address);
    }

    public void removeAddress(Address address) {
        user.getAddresses().remove(address);
    }

    public AuthenticationStatus getAuthenticationStatus() {
        return authenticationStatus;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Insurance> getInsurances() {
        return insurances;
    }

    public abstract void addInsurance(Insurance insurance);

    public abstract void showUserInfo();

    public int compareTo(Account other) {
        return 0;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}