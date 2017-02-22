import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;

/**
 * Created by MiguelHuerta on 2/20/17.
 */

/**
 * PinEncrypterDecrypter class
 *
 * @author MiguelHuerta <guelme88@gmail.com>
 */
public class PinEncrypterDecrypter {

    /**
     * Algorithm variable
     *
     * @var algorithm
     */
    private String algorithm;

    /**
     * Key variable
     *
     * @var Key
     */
    private Key key;

    /**
     * Cipher var
     *
     * @var Cipher
     */
    private Cipher cipher;

    /**
     * contructor
     *
     * @return void
     */
    PinEncrypterDecrypter()
    {
        this.algorithm = "DESede";
        this.key = null;
        this.cipher = null;
        // we try to set up the cipher
        this.setup();
    }

    /**
     * set up function
     *
     * @return void
     */
    protected void setup()
    {
        try {
            this.key = KeyGenerator.getInstance(this.algorithm).generateKey();
            this.cipher = Cipher.getInstance(this.algorithm);
        } catch (Exception exception) {
            System.out.println("Error! We failed when trying to set up the cipher");
        }
    }

    /**
     * Encrypt function
     *
     * @param int pin
     *
     * @return array encryptedString
     */
    public byte[] encrypt(int pin)
    {
        byte[] encrypted = null;
        try {
            this.cipher.init(Cipher.ENCRYPT_MODE, this.key);

            String stringPin = String.valueOf(pin);
            // array of bytes
            byte[] inputBytes = stringPin.getBytes();

            encrypted = this.cipher.doFinal(inputBytes);

        } catch(Exception exception) {
            System.out.println("Exception thrown inside encrypt");
        }

        return encrypted;
    }

    /**
     * decrypt function
     *
     * @param String encryptedString
     *
     * @return int
     */
    public int decrypt(byte[] encryptedString)
    {
        String decrypted = null;
        try {
            this.cipher.init(Cipher.DECRYPT_MODE, this.key);

            decrypted = new String(this.cipher.doFinal(encryptedString));
        } catch(Exception exception) {
            System.out.println("Exception thrown inside decrypt");
        }

        return Integer.parseInt(decrypted);
    }
}
