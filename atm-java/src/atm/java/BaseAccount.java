package atm.java;

/**
 * Created by MiguelHuerta on 2/18/17.
 */

/**
 * Base Account class that will be abstract.
 *
 * @author Miguel Huerta <guelme88@gmail.com>
 */
public abstract class BaseAccount {
    /**
     * First Name
     *
     * @var String firstName
     */
    public String firstName;

    /**
     * Balance
     *
     * @var double balance
     */
    public double balance;

    /**
     * Acount Number
     *
     * @var String accountNumber
     */
    public int accountNumber;

    // define the method that will be included when a class extends this class

    /**
     * Contructor
     * @param name
     * @param initBalance
     * @param account
     */
    BaseAccount(String name, double initBalance, int account)
    {
        firstName = name;
        balance = initBalance;
        accountNumber = account;
    }

    /**
     * set First name method
     * @param name
     *
     * @return void
     */
    public void setFirstName(String name)
    {
        firstName = name;
    }

    /**
     * Get first name
     *
     * @return String firstName
     */
    public String getFirstName() { return firstName;}

    /**
     * Set Account number
     * @param setNumber
     *
     * @return void
     */
    public void setAccountNumber(int setNumber)
    {
        accountNumber = setNumber;
    }

    /**
     * Get Account number
     *
     * @return int
     */
    public int getAccountNumber()
    {
        return this.accountNumber;
    }

    /**
     * Get account balance
     *
     * @return double balance
     */
    public double getBalance()
    {
        return balance;
    }

    /**
     * toString method
     *
     * @return String
     */
    public String toString()
    {
        // display how the account information should be displayed.
        String toString = "Account Information";
        toString += "\n\tName: " + this.firstName;
        toString += "\n\tAccount Number: " + this.accountNumber;
        toString += "\n\tBalance: $" + this.balance;

        return toString;
    }

    // define the abstract method that each class will have to define

    /**
     * Abstract method
     *
     * @param add
     */
    abstract void depositAmount(double add);

    /**
     * Abstract method. To withdraw amount.
     *
     * @param amount
     */
    abstract void withdrawAmount(double amount);
}
