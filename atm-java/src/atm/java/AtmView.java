package atm.java;

/**
 * Created by Jerry Landeros on 2/18/2017.
 */
public class AtmView {

    /**
     * Constructor method.
     *
     * @return view
     */
    AtmView()
    {
        // this function will initially display the menu. to make the menu reusable we will call an internal function
        this.displayMenu();
    }

    /**
     * Method that will display the menu for the user.
     *
     * @return void
     */
    protected void displayMenu()
    {
        // as of now we are just dumping the text to the terminal
        System.out.println("||=====================================================================||");
        System.out.println("||  Welcome to the ATM machine. Please make a selection to begin.      ||");
        System.out.println("||      1) Display Account Information                                 ||");
        System.out.println("||      2) Make Deposit                                                ||");
        System.out.println("||      3) Withdraw Money                                              ||");
        System.out.println("||      4) End Session                                                 ||");
        System.out.println("||                                                                     ||");
        System.out.println("=======================================================================||");

        // the view is complete. We listen for the selection inside the controller.
    }

    /**
     *
     * @param balance
     *
     * @return String
     */
    public void displayBalance(double balance) {
        System.out.println("Your balance is: " + balance);
    }

    /**
     *
     * @param name
     *
     * @return String
     */
    public void displayFirstName(String name){
        System.out.print("Hello! Welcome " + name + "!");
    }
}

