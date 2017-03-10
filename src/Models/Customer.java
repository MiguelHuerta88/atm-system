package Models;

import java.security.SecureRandom;
import Helpers.*;
/**
 * Created by MiguelHuerta on 2/19/17.
 */
public class Customer {

    /**
     * First Name
     *
     * @var String firstName
     */
    protected String firstName;

    /**
     * last name
     *
     * @var String lastname
     */
    protected String lastName;

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
    protected String address;

    /**
     * State variable
     *
     * @var String
     */
    protected String state;

    /**
     * City for user
     *
     * @string city
     */
    protected String city;

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
    private String pin;

    /**
     * username variable
     *
     * @var username
     */
    private String username;

    /**
     * random salt variable
     *
     * @var SecureRandom
     */
    private SecureRandom salt;

    /**
     * phone number variable
     *
     * @var int phone
     */
    protected long phone;

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
     * @param int pin
     * @param String username
     * @param long phone
     */
    public Customer(
            int id,
            String firstName,
            String lastName, String address,
            String city, String state,
            int zip,
            int pin,
            String username,
            long phone
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.username = username;
        this.phone = phone;

        this.hashPin(pin);
    }

    /**
     * hash pin function
     *
     * @param int pin
     *
     * @return void
     */
    private void hashPin(int pin)
    {
        // generate a random salt
        this.salt = new SecureRandom();
        byte bytes[] = new byte[20];
        this.salt.nextBytes(bytes);
        // end of salt

        // hash the pin
        Hasher hasher = new Hasher();
        this.pin = hasher.hashPin(pin, this.salt);
    }

    /* create all getters and setter */

    /**
     * Get pin
     *
     * @return byte[] pin
     */
    public String getPin()
    {
        return this.pin;
    }

    /**
     * get the phone
     *
     * @return int
     */
    public long getPhone()
    {
        return this.phone;
    }

    /**
     * get salt
     *
     * @return SecureRandom
     */
    public SecureRandom getSalt()
    {
        return this.salt;
    }

    /**
     * get customer id
     *
     * @return int
     */
    public int getCustomerId()
    {
        return this.id;
    }

    /**
     * get username
     *
     * @return String
     */
    public String getUsername()
    {
        return this.username;
    }

    /**
     * toString method for a Customer
     *
     * @return String
     */
    public String toString()
    {
        // return all the information for the object
        String toString = "\n\tCustomer Name:  " + this.firstName + " " + this.lastName;
        toString += "\n\tAddress:        " + this.address +", " + this.city + ", " + this.state + " " + this.zip;
        return toString;
    }

}
