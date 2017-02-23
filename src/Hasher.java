
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by MiguelHuerta on 2/22/17.
 */
public class Hasher {

    /**
     * Salt
     */
    private final String  SALT = "S3rg!0G0D0S0m3c0d!ng#@8";

    /**
     * text to be hashed variable
     *
     * @var text
     */
    private String text;

    /**
     * Constructor
     * @param text
     */
    Hasher(String text) {
        this.text = text;
    }

    /**
     * Protected function to hash using MD5 algorithm
     *
     * @return String
     */
    protected String hashText()
    {
        String md5 = null;

        if(this.text == null) {
            // failure
            return null;
        }

        // try catch
        try{
            MessageDigest digest = MessageDigest.getInstance("MD5");

            // we add the salt to the current string
            String preparedText = SALT + this.text;

            // update text in message digest
            digest.update(preparedText.getBytes(), 0, preparedText.length());

            // convert message digest to Hex
            md5 = new BigInteger(1, digest.digest()).toString(16);

        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5;
    }
}
