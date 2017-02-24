import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;

/**
 * Created by Jerry Landeros on 2/17/2017.
 */
public class AtmController {

    // these are null at first
    private Customer customerModel = null;
    private AtmView view;

    private HashMap<Integer, Account> accounts;
    private ArrayList<Customer> customers;
    private HashMap<Integer, AccountType> accountTypes;

    // transaction records for now will be stored in arraylist
    private ArrayList<Transaction> transactions;

    public AtmController(HashMap<Integer, Account> accounts, ArrayList<Customer> customers, HashMap<Integer, AccountType> accountTypes, AtmView view)
    {
        /*this.accountModel = accountModel;
        this.customerModel = customerModel;
        this.accountTypeModel = accountTypeModel;*/
        this.accounts = accounts;
        this.customers = customers;
        this.accountTypes = accountTypes;
        this.view = view;

        // set up the transactions
        this.transactions = new ArrayList<Transaction>();
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
                    return true;
                }
            }
            counter--;
        }
        return false;
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
            Hasher hasher = new Hasher(String.valueOf(pin));

            // check if they match
            if(hasher.hashText().equals(customerModel.getPin())) {
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
                //String accountInfo = this.accountModel.toString();
                //accountInfo += this.customerModel.toString();

                //this.view.displayMessage(accountInfo);

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

}
