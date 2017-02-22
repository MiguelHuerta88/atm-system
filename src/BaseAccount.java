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

    /**
     * Account type id
     *
     * @var int type_id(1|2)
     */
    public int typeId;

    /**
     * last access time
     *
     * @var timestamp
     */
    public String lastAccessTime;

    // define the method that will be included when a class extends this class

    /**
     * Contructor
     * @param int account
     * @param initBalance
     * @param int accountTypeIf
     * @param String accessTime
     */
    BaseAccount(int account, double initBalance, int accountTypeId, String accessTime)
    {
        balance = initBalance;
        accountNumber = account;
        typeId = accountTypeId;
        lastAccessTime = accessTime;
    }

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
     * Get account type id
     *
     * @return int
     */
    public int getAccountTypeId()
    {
        return this.typeId;
    }

    /**
     * Set account type id
     *
     * @param int
     * @return void
     */
    public void setAccountTypeId(int typeId)
    {
        this.typeId = typeId;
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
