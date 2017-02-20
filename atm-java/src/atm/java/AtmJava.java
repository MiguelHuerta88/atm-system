/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.java;

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
        CheckingAccount account = new CheckingAccount(156843, 1000.00, 1, "2017-02-19 22:00:00");
        Customer customer = new Customer(1, "Sergio", "Vasquez", "123 Apple St", "Los Angeles", "CA", 90745);
        AccountType accountType = new AccountType(1, "Checking");

        AtmView displayView =  new AtmView();

//        displayView.mainMenu();
        //System.out.println(test.getBalance());
        AtmController atmController = new AtmController(account, customer, accountType, displayView);

        // show the menu
        atmController.initView();

        // listen call function to listen for selections
        atmController.listenForSelection();

        //atmController.displayBalance();
        //atmController.displayFirstName();


        // TODO code application logic here
    }
    
}
