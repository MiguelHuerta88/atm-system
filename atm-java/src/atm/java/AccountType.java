package atm.java;

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
    AccountType(int typeId, String type)
    {
        this.typeId = typeId;
        this.type = type;
    }

    /* make the getters and setters */
}
