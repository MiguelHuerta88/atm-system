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
        Account account = new Account("Sergio", 5.0, 12345);
        AtmView displayView =  new AtmView();

//        displayView.mainMenu();
        //System.out.println(test.getBalance());
        AtmController atmController = new AtmController(account, displayView);

        //atmController.displayBalance();
        //atmController.displayFirstName();


        // TODO code application logic here
    }
    
}
