package atm.java;

/**
 * Created by Jerry Landeros on 2/17/2017.
 */
public class AtmController {
    private Account model;
    private AtmView view;

    public AtmController(Account model, AtmView view){
        this.model = model;
        this.view = view;
    }

    public void displayBalance() {
        double balance = model.getBalance();

        view.displayBalance(balance);
    }

    public void displayFirstName(){
        String name = model.getFirstName();

        view.displayFirstName(name);

    }


}
