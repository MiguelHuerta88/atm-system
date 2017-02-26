/**
 * Created by MiguelHuerta on 2/19/17.
 */
public class Transaction {

    /**
     * Timestamp for transaction
     *
     * @param String timestamp
     */
    public String timestamp;

    /**
     * Amount value
     *
     * @param double amount
     */
    public double amount;

    /**
     * Account id - relation to how to know which account if came from.
     *
     * @param int accountId
     */
    public int accountId;

    /**
     *
     * @param timestamp
     * @param amount
     * @param accountId
     */
    Transaction(String timestamp, double amount, int accountId)
    {
        this.timestamp = timestamp;
        this.amount = amount;
        this.accountId = accountId;
    }

    /* make getter and setters, along with toString */

    public String toString()
    {
        String toString = "";

        toString += "Timestamp:\t" + this.timestamp + "\n";
        toString += "Amount:\t" + this.amount + "\n";
        toString += "Account Id:\t" + this.accountId + "\n";
        toString += "==================================\n";
        return toString;
    }
}
