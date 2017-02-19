package atm.java;


import java.io.*;
import java.util.Scanner;

/**
 * Created by Jerry Landeros on 2/17/2017.
 */
public class AtmController {

    private Account model;
    private AtmView view;

    public AtmController(Account model, AtmView view)
    {
        this.model = model;
        this.view = view;
    }

    public void displayBalance()
    {
        double balance = model.getBalance();

        view.displayBalance(balance);
    }

    public void displayFirstName()
    {
        String name = model.getFirstName();

        view.displayFirstName(name);

    }

    /**
     * Init View
     *
     * @return view
     */
    public void initView()
    {
        this.view.displayMenu();
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
                String accountInfo = this.model.toString();

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
