package flight.reservation.payment;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Paypal {
    // Maps emails to passwords
    public static final Map<String, byte[]> DATA_BASE = new HashMap<>();

    public static byte[] hash(String input) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return digest.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    static {
        DATA_BASE.put("amanda@ya.com", hash("amanda1985"));
        DATA_BASE.put("john@amazon.eu", hash("qwerty"));
    }
}
