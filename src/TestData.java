/**
 * Created by MiguelHuerta on 2/26/17.
 */

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class where the dev could seed the project with some test data
 *
 * @author Jerry Landeros
 * @author Miguel Huerta
 */
public class TestData {

    /**
     * seed some test customers
     *
     * @return ArrayList<Customer>
     */
    public ArrayList<Customer> seedCustomers()
    {
        Customer customer;
        ArrayList<Customer> customers = new ArrayList<Customer>();

        customer = new Customer(1, "Sergio", "Vasquez", "123 Apple St", "Los Angeles", "CA", 90745, 1234, "svasquez", new Long("3233203456").longValue());
        customers.add(customer);

        customer  = new Customer(2, "Heidi", "Vasquez", "123 Apple St", "Los Angeles", "CA", 90745, 1234, "hvasquez", new Long("3234364490").longValue());
        customers.add(customer);

        customer = new Customer(3, "Miguel", "Huerta", "3081 Oregon st", "Los Angeles", "CA", 90023, 3456, "mhuerta", new Long("3103676337").longValue());
        customers.add(customer);

        return customers;
    }

    /**
     * seed some test accounts
     *
     * @return ArrayList<Account>
     */
    public ArrayList<Account> seedAccounts()
    {
        CheckingAccount account;
        SavingsAccount saving;
        ArrayList<Account> accounts = new ArrayList<Account>();

        account = new CheckingAccount(156843, 1000.00, 1, "2017-02-19 22:00:00", 1);
        accounts.add(account);

        account = new CheckingAccount(156843, 1000.00, 1, "2017-02-19 10:05:00", 2);
        accounts.add(account);

        saving = new SavingsAccount(167894, 10000, 2, "2017-02-23 10:59:00", 1);
        accounts.add(saving);

        return accounts;
    }

    /**
     * seed the account types
     *
     * @return HashMap
     */
    public HashMap<Integer, AccountType> seedAccountTypes()
    {
        HashMap<Integer, AccountType> accountTypes = new HashMap<Integer, AccountType>();
        AccountType accountType;

        accountType = new AccountType(1, "Checking");
        accountTypes.put(accountType.getAccountType(), accountType);

        accountType = new AccountType(2, "Savings");
        accountTypes.put(accountType.getAccountType(), accountType);

        return accountTypes;
    }
}
