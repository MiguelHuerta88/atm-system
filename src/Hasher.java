
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by MiguelHuerta on 2/22/17.
 */
public class Hasher
{
    public static String algorithm = "SHA-256";
    /**
     * Protected function to hash using MD5 algorithm
     *
     * @return String
     */
    protected String hashPin(int pin, SecureRandom salt)
    {
        byte[] hashed = null;
        String hashedPin = null;

        // try catch
        try{
            MessageDigest digest = MessageDigest.getInstance(algorithm);

            // we add the salt to the current pin passed
            String preparedText = salt + String.valueOf(pin);

            // update text in message digest
            digest.update(preparedText.getBytes(), 0, preparedText.length());

            // run the digest call
            hashed = digest.digest();

            // convert it to hex
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< hashed.length ;i++)
            {
                sb.append(Integer.toString((hashed[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
             hashedPin = sb.toString();

        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return hashedPin;
    }

    /**
     * function to check if the passed in hashes match using Message Digest
     *
     * @param String customerPinHashed
     * @param String enteredPinHashed
     *
     * @return boolean
     */
    protected boolean doHashesMatch(String customerPinHashed, String enteredPinHashed)
    {
        try {
            // message digest
            MessageDigest digest = MessageDigest.getInstance(algorithm);

            if(digest.isEqual(customerPinHashed.getBytes(), enteredPinHashed.getBytes())) {
                return true;
            }

        } catch(NoSuchAlgorithmException e) {
            System.out.println(e.getStackTrace());
            return false;
        }
        return false;
    }
}
