package InsuranceCompany;

import java.util.TreeSet;

class AccountManager {
    private final TreeSet<Account> accounts;

    public AccountManager() {
        this.accounts = new TreeSet<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account login(String email, String password) {
        for (Account account : accounts) {
            try {
                account.login(email, password);
                return account;
            } catch (InvalidAuthenticationException ignored) {
                System.out.println("InvalidAuthenticationException");
            }
        }
        return null;
    }
}
