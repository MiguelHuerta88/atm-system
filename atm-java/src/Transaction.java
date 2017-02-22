/**
 * Created by MiguelHuerta on 2/19/17.
 */
public class Transaction {

    /**
     * id
     * @var int id
     */
    public int id;

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
     * @param id
     * @param timestamp
     * @param amount
     * @param accountId
     */
    Transaction(int id, String timestamp, double amount, int accountId)
    {
        this.id = id;
        this.timestamp = timestamp;
        this.amount = amount;
        this.accountId = accountId;
    }

    /* make getter and setters, along with toString */
}
