package atm.java;

/**
 * Created by MiguelHuerta on 2/17/17.
 */
public class Account extends BaseAccount
{

    /**
     * Account Type
     * @param accountType
     *
     */
    public String accountType;


    public Account(String name, double initBalance, int account)
    {
        // call the super method on the abstract class.
        super(name, initBalance, account);

        accountType = "checking"; // hardcoded for now.

    }

    public String getAccountType()
    {
        return accountType;
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

        // append to that output.
        toString += "\n\tAccount Type: " + this.accountType;

        return toString;
    }
}
