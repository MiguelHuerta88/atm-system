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
     * pin variable
     *
     * @var pin
     */
    public byte[] pin;

    /**
     * PinEncrypterDecrypter var
     *
     * @var PinEncrypterDecrypter
     */
    protected PinEncrypterDecrypter pinEncrypterDecrypter;

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
     * @param byte[] pin
     */
    Customer(int id, String firstName, String lastName, String address, String city, String state, int zip, int pin)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;

        // encrypter
        this.pinEncrypterDecrypter = new PinEncrypterDecrypter();
        this.pin = this.pinEncrypterDecrypter.encrypt(pin);

    }

    /* create all getters and setter */

    /**
     * Get pin
     *
     * @return byte[] pin
     */
    public byte[] getPin()
    {
        return this.pin;
    }

    /**
     * get PinEncrypterDecrypter instance
     *
     * @return PinEncrypterDecrypter
     */
    public PinEncrypterDecrypter getPinEncrypterDecrypter()
    {
        return this.pinEncrypterDecrypter;
    }
}
