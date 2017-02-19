package atm.java;

/**
 * Created by MiguelHuerta on 2/19/17.
 */
public class Customer {

    /**
     * First Name
     *
     * @var String firstName
     */
    public String firstName;

    /**
     * last name
     *
     * @var String lastname
     */
    public String lastName;

    /**
     * Id for customer
     *
     * @var int id
     */
    public int id;

    /**
     * Address for user
     *
     * @var String
     */
    public String address;

    /**
     * State variable
     *
     * @var String
     */
    public String state;

    /**
     * City for user
     *
     * @string city
     */
    public String city;

    /**
     * Zip variable
     *
     * @var int
     */
    public int zip;

    /**
     * Constructor goes here
     *
     * @param int id
     * @param String firstName
     * @param String lastName
     * @param String address
     * @param String city
     * @param String state
     * @param int zip
     */
    Customer(int id, String firstName, String lastName, String address, String city, String state, int zip)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    /* create all getters and setter */
}
