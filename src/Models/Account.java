package Models;

/**
 * Created by MiguelHuerta on 3/8/17.
 */
public class Account extends BaseAccount {

    public Account(int account, double initBalance, int typeId, String lastAccess, int customerId)
    {
        // call the constructor
        super(account, initBalance, typeId, lastAccess, customerId);
    }

    /**
     * Basic deposit function. Each model that extends should override to their needs.
     *
     * @param add
     */
    public void depositAmount(double add)
    {
        this.balance += add;
    }

    /**
     * basic withdraw function. Each model that extends should override to their needs
     *
     * @param amount
     */
    public void withdrawAmount(double amount)
    {
        this.balance -= amount;
    }
}
