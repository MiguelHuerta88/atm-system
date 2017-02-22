import java.util.Scanner;

/**
 * Created by Jerry Landeros on 2/17/2017.
 */
public class AtmController {

    private CheckingAccount accountModel;
    private Customer cutomerModel;
    private AccountType accountTypeModel;
    private AtmView view;

    public AtmController(CheckingAccount accountModel, Customer customerModel, AccountType accountTypeModel, AtmView view)
    {
        this.accountModel = accountModel;
        this.cutomerModel = customerModel;
        this.accountTypeModel = accountTypeModel;
        this.view = view;
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
        if(this.pinMatches(this.cutomerModel))
        {
            this.view.displayMenu();
        } else {
            // if we reached here. the user could not match the pin
            this.view.displayMessage("You have reached max number of tries for pin.");
            this.view.displayMessage("Terminating program. Goodbye");
            System.exit(0);
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

        // decrypt the pin
        int decryptedPin = customerModel.getPinEncrypterDecrypter().decrypt(customerModel.getPin());

        // scanner
        Scanner sc = new Scanner(System.in);


        // we give the user three tries to enter a valid matching pin. otherwise we end the program
        while(counter > 0) {
            this.view.displayMessageSameLine("Enter pin for account: ");

            int pin = sc.nextInt();

            // check if they match
            if(pin == decryptedPin) {
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
                String accountInfo = this.accountModel.toString();

                this.view.displayMessage(accountInfo);

                // display selection menu again
                this.view.displayMenu();
                break;

            case 2:

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
