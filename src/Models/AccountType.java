package Models;

/**
 * Created by MiguelHuerta on 2/19/17.
 */
public class AccountType {

    /**
     * Type id
     *
     * @var int typeId
     */
    public int typeId;

    /**
     * Type
     *
     * @var String type
     */
    public String type;

    /**
     *
     * @param typeId
     * @param type
     */
    public AccountType(int typeId, String type)
    {
        this.typeId = typeId;
        this.type = type;
    }

    /* make the getters and setters */

    /**
     * get account type
     *
     * @return int
     */
    public int getAccountType()
    {
        return this.typeId;
    }

    /**
     * get type text
     *
     * @return String
     */
    public String getType()
    {
        return this.type;
    }
}
