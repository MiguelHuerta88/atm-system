/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author MiguelHuerta
 */
public class AtmJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Customer customer = new Customer(1, "Sergio", "Vasquez", "123 Apple St", "Los Angeles", "CA", 90745, 1234, "svasquez");
        Customer customer2 = new Customer(2, "Heidi", "Vasquez", "123 Apple St", "Los Angeles", "CA", 90745, 1234, "hvasquez");

        ArrayList<Customer> customers = new ArrayList<Customer>();
        customers.add(customer);
        customers.add(customer2);

        CheckingAccount account = new CheckingAccount(156843, 1000.00, 1, "2017-02-19 22:00:00", 1);
        CheckingAccount account2 = new CheckingAccount(156843, 1000.00, 1, "2017-02-19 10:05:00", 2);

        SavingsAccount saving = new SavingsAccount(167894, 10000, 2, "2017-02-23 10:59:00", 1);

        ArrayList<Account> accounts = new ArrayList<Account>();
        accounts.add(account);
        accounts.add(account2);
        accounts.add(saving);

        AccountType accountType = new AccountType(1, "Checking");
        AccountType savingType = new AccountType(2, "Savings");

        HashMap<Integer, AccountType> accountTypes = new HashMap<Integer, AccountType>();
        accountTypes.put(accountType.getAccountType(), accountType);
        accountTypes.put(savingType.getAccountType(), savingType);

        AtmView displayView =  new AtmView();

        // this will change once we move to a database system. the customer and accounts will
        // be pulled inside controller based on accountId or some field to be searched on
        AtmController atmController = new AtmController(accounts, customers, accountTypes, displayView);

        // show the menu
        atmController.initView();

        // listen call function to listen for selections
        atmController.listenForSelection();

    }
    
}
