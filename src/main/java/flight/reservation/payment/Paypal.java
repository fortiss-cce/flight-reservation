package flight.reservation.payment;

import java.util.HashMap;
import java.util.Map;
import flight.reservation.payment.PaymentStrategy;


public class Paypal extends PaymentStrategy {
    
    static public class PaypalManager{
        public static final Map<String, String> DATA_BASE = new HashMap<>();
    
        static {
            DATA_BASE.put("amanda1985", "amanda@ya.com");
            DATA_BASE.put("qwerty", "john@amazon.eu");
        }
        public void addUserToDatabase(String username, String password){
            DATA_BASE.put(username, password);
        }
    }

    public Paypal(String email, String password){
        this.loginUsername = email;
        this.loginSecret = password;
    }
    
    @Override
    public boolean pay(double amount){
        if (this.loginUsername.equals(PaypalManager.DATA_BASE.get(loginSecret))) {
            System.out.println("Paying " + amount + " using PayPal.");
        return true;
        }
        else{
            return false;
        }
    }
}
