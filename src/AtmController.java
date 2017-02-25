import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;

/**
 * Created by Jerry Landeros on 2/17/2017.
 */
public class AtmController {

    // these are null at first
    private Customer customerModel;
    private AtmView view;
    private ArrayList<Account> customerAccounts;

    private ArrayList<Account> accounts;
    private ArrayList<Customer> customers;
    private HashMap<Integer, AccountType> accountTypes;

    // transaction records for now will be stored in arraylist
    private ArrayList<Transaction> transactions;

    public AtmController(ArrayList<Account> accounts, ArrayList<Customer> customers, HashMap<Integer, AccountType> accountTypes, AtmView view)
    {
        // all accounts of test data
        this.accounts = accounts;

        // all customers with test data
        this.customers = customers;
        this.accountTypes = accountTypes;
        this.view = view;

        // set up the transactions
        this.transactions = new ArrayList<Transaction>();
        this.customerAccounts = new ArrayList<Account>();
    }

    public void displayBalance()
    {
        //double balance = model.getBalance();

        //view.displayBalance(balance);
    }

    public void displayFirstName()
    {
        //String name = model.getFirstName();

        //view.displayFirstName(name);

    }

    /**
     * Init View
     *
     * @return view
     */
    public void initView()
    {
        // before we display the menu we have to ask the user for their pin
        if(this.pullupCustomer())
        {
            //this.view.greetUser(this.customerModel.firstName);
            this.view.displayMenu();
        } else {
            // if we reached here. the user could not match the pin
            this.view.displayMessage("You have reached max number of tries for pin.");
            this.view.displayMessage("Terminating program. Goodbye");
            System.exit(0);
        }
    }

    /**
     * display menu to find a customer before we can begin the program
     *
     * @return boolean
     */
    public boolean pullupCustomer()
    {
        // this whole section can me optimized some. Work on this after we get it working correctly.
        Scanner sc = new Scanner(System.in);

        int counter = 3;

        Customer customer = null;
        while(counter > 0) {
            this.view.displayMessageSameLine("Enter username:");
            String username = sc.next();
            // iterator
            Iterator<Customer> iterator = this.customers.iterator();

            // loop
            boolean match = false;
            while(iterator.hasNext()) {
                customer = iterator.next();
                if(customer.getUsername().equals(username)) {
                    match = true;
                    // matched a customer. break out of loop
                    break;
                }
            }

            if(match) {
                // we have a customer check their pin not
                if(this.pinMatches(customer)){

                    // we matched a customer. set the variables that will be used by the controller
                    this.customerModel = customer;

                    // we populate our variable for the customer accounts
                    this.populateListOfCustomerAccounts(this.accounts);
                    return true;
                }
            }
            counter--;
        }
        return false;
    }

    /**
     * function to populate only the accounts for this customers in our customerAccounts variable
     *
     * @param ArrayList<Account>
     *
     * @return void
     */
    protected void populateListOfCustomerAccounts(ArrayList<Account> accounts)
    {
        // we need to loop and only add when they match the current customer that is set
        if(this.customerModel == null) {
            // terminate. user reached here incorrectly
            System.exit(0);
        }

        // pull what we will be searching for from the customer model
        int customerId = this.customerModel.getCustomerId();
        for(Account account : accounts)
        {
            if(account.getCustomerId() == customerId) {
                customerAccounts.add(account);
            }
        }
    }

    /**
     * Function to decrypt customer pin and check if it matches what was entered
     *
     * @param Customer customerModel
     *
     * @return boolean
     */
    protected boolean pinMatches(Customer customerModel)
    {
        // counter
        int counter = 3;

        // scanner
        Scanner sc = new Scanner(System.in);


        // we give the user three tries to enter a valid matching pin. otherwise we end the program
        while(counter > 0) {
            this.view.displayMessageSameLine("Enter pin for account: ");

            int pin = sc.nextInt();

            // hash the pin to try to match
            Hasher hasher = new Hasher();

            String enteredPinHashed = hasher.hashPin(pin, customerModel.getSalt());

            if(hasher.doHashesMatch(customerModel.getPin(), enteredPinHashed))
            {
                return true;
            }
            counter--;
        }
        return false;
    }

    /**
     * Listen for selection function
     *
     * @return view
     */
    public void listenForSelection()
    {
        // this is where we listen for which button is selected and call appropriate function to handle request
        // then update the view

        Scanner sc = new Scanner(System.in);

        // bool value to tell us to stop
        boolean session = true;

        while(session) {
            int selection = sc.nextInt();

            // call a function to determine what we selected and then passes data to view
            session = this.performSelection(selection);
        }
    }

    /**
     * Function to determine what action to take based on selection
     *
     * @param int selection
     *
     * @return boolean
     */
    protected boolean performSelection(int selection)
    {
        switch(selection) {
            case 1:
                // display the account info
                String info = this.customerModel.toString() + "\n\n";
                info += this.buildAccountString();

                this.view.displayMessage(info);

                // display selection menu again
                this.view.displayMenu();
                break;

            case 2:

                this.view.depositMenu();
                break;

            case 3:

                break;

            case 4:
                // output a closing app message.
                String closing = "You selected to end your session. Thank you for using this ATM.\n";
                this.view.displayMessage(closing);
                break;

            default:
                // for default we just reload the selection menu. along wiht message stating that selection is invalid.
                String text = "You have made an invalid selection. Come on BROOOO! \n\n\n";
                this.view.displayMessage(text);
                // display selection menu again
                this.view.displayMenu();
        }

        return selection == 4 ? false : true;
    }

    /**
     * function to loop through any accounts for the current customer and call the toString
     *
     * @return String
     */
    public String buildAccountString()
    {
        String toString = "";

        //

        for(Account account : this.customerAccounts)
        {
            toString += "\t===========================";
            toString += "\n\t" + account.toString();
            toString += "\n\tType of Account: " + this.accountTypes.get(account.getAccountTypeId()).getType() + "\n";
        }

        return toString + "\n\n";
    }

}
