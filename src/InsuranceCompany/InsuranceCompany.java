package InsuranceCompany;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class InsuranceCompany {
    public static void main(String[] args) {

        User user = new User("John", "Doe", "johndoe@example.com", "password", "Engineer", 30,
                new ArrayList<>(), new Date());

        Account account = new Individual(user);
        AccountManager accountManager = new AccountManager();
        accountManager.addAccount(account);


        Scanner scanner = new Scanner(System.in);
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        account = accountManager.login(email, password);
        if (account != null) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid email or password. Login failed!");
        }
    }
}
