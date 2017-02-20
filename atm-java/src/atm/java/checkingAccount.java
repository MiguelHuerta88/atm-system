package atm.java;

/**
 * Created by MiguelHuerta on 2/17/17.
 */
public class checkingAccount extends BaseAccount
{

    public checkingAccount(int account, double initBalance, int typeId, String lastAccess)
    {
        // call the super method on the abstract class.
        super(account, initBalance, typeId, lastAccess);
    }

    public void  depositAmount(double add)
{
    balance += add;
}

    public void withdrawAmount(double amount)
{
    balance -= amount;
}

    /**
     * toString method
     *
     * @return String
     */
    public String toString()
    {
        // display how the account information should be displayed.
        String toString = super.toString();

        return toString;
    }
}
