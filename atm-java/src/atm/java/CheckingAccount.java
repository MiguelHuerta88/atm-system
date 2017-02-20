package atm.java;

/**
 * Created by MiguelHuerta on 2/17/17.
 */
public class CheckingAccount extends BaseAccount
{
    public static final double WITHDRAW_MAX = 500.00;

    public CheckingAccount(int account, double initBalance, int typeId, String lastAccess)
    {
        // call the super method on the abstract class.
        super(account, initBalance, typeId, lastAccess);
    }

    public void depositAmount(double add)
    {
        if(balance > 0)
        {
            balance +=add;
        }
    }

    public void withdrawAmount(double amount)
    {

        if ((balance > 0 && amount < balance) && (amount > 0 && amount <= WITHDRAW_MAX) )
        {
            balance -= amount;
        }
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

