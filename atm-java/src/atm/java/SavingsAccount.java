package atm.java;

/**
 * Created by Darkness (Jerry Landeros) on 2/20/2017.
 */
public class SavingsAccount extends BaseAccount
{
    public final double WITHDRAW_MAX = 2000.00;

    public SavingsAccount(int account, double initBalance, int typeId, String lastAcces)
    {
        super(account, initBalance, typeId, lastAcces);
    }

    public void depositAmount(double deposit)
    {
        if(deposit > 0)
        {
            balance += deposit;
        }
    }

    public void withdrawAmount(double withdraw)
    {
        if ((balance > 0 && withdraw < balance) && (withdraw > 0 && withdraw <= WITHDRAW_MAX) )
        {
            balance -= withdraw;
        }
    }

    public String toString()
    {
        return super.toString();
    }
}
