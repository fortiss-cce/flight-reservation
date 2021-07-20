package flight.reservation.payment;

import java.util.HashMap;
import java.util.Map;

public class Paypal extends APaymentMethod {
    public static final Map<String, String> DATA_BASE = new HashMap<>();

    static {
        DATA_BASE.put("amanda1985", "amanda@ya.com");
        DATA_BASE.put("qwerty", "john@amazon.eu");
    }

    private final String email;
    private final String password;

    public Paypal(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean pay(double amount) {
        if (isValid()) {
            System.out.println("Paying " + amount + " using PayPal.");
            return true;
        }
        return false;
    }

    @Override
    public boolean isValid() {
        return email != null && password != null && email.equals(Paypal.DATA_BASE.get(password));
    }
}
