/**
 * Created by MiguelHuerta on 2/18/17.
 */

/**
 * Base Account class that will be abstract.
 *
 * @author Miguel Huerta <guelme88@gmail.com>
 */
abstract class BaseAccount {

    /**
     * Balance
     *
     * @var double balance
     */
    protected double balance;

    /**
     * Acount Number
     *
     * @var String accountNumber
     */
    protected int accountNumber;

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

    /**
     * customer id
     *
     * @var customerId
     */
    protected int customerId;


    /**
     * Contructor
     * @param int account
     * @param init Balance
     * @param int accountTypeIf
     * @param String accessTime
     **/
    BaseAccount(int account, double initBalance, int accountTypeId, String accessTime, int cusId)
    {
        balance = initBalance;
        accountNumber = account;
        typeId = accountTypeId;
        lastAccessTime = accessTime;
        customerId = cusId;
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
     * Get customerId
     *
     * @return int
     */
    public int getCustomerId()
    {
        return customerId;
    }

    /**
     * toString method
     *
     * @return String
     */
    public String toString()
    {
        String toString = "Account Information";
        toString += "\n\tAccount Number: " + this.accountNumber;
        toString += "\n\tBalance:        $ " + this.balance;
        toString += "\n\tAccessed Last:  " + this.lastAccessTime;
        return toString;
    }

    // define the abstract method that each class will have to define
    /**
     * Basic deposit function. Each model that extends should override to their needs.
     *
     * @param add
     */
    abstract public void depositAmount(double add);

    /**
     * basic withdraw function. Each model that extends should override to their needs
     *
     * @param amount
     */
    abstract public void withdrawAmount(double amount);
}
