/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controller.AtmController;
import Views.AtmView;

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
        // this will change once we move to a database system. the customer and accounts will
        // be pulled inside controller based on accountId or some field to be searched on
        AtmController atmController = new AtmController(new AtmView());
    }
    
}
