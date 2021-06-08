package flight.reservation.payment;

import flight.reservation.order.FlightOrder;

import java.util.HashMap;
import java.util.Map;

public class Paypal extends PaymentMethod {
    public static final Map<String, String> DATA_BASE = new HashMap<>();

    static {
        DATA_BASE.put("amanda1985", "amanda@ya.com");
        DATA_BASE.put("qwerty", "john@amazon.eu");
    }

    final String email;
    final String password;


   public Paypal(String email, String password)  {
       super();
       this.email = email;
       this.password = password;
   }


    public boolean processOrder(FlightOrder flightOrder) throws IllegalStateException {
        if (flightOrder.isClosed()) {
            // Payment is already proceeded
            return true;
        }
        // validate payment information
        if (email == null || password == null || !email.equals(DATA_BASE.get(password))) {
            throw new IllegalStateException("Payment information is not set or not valid.");
        }
        boolean isPaid = pay(flightOrder, flightOrder.getPrice());
        if (isPaid) {
            flightOrder.setClosed();
        }
        return isPaid;
    }

    @Override
    public boolean pay(FlightOrder flightOrder, double amount) throws IllegalStateException {
        if (email.equals(DATA_BASE.get(password))) {
            System.out.println("Paying " + flightOrder.getPrice() + " using PayPal.");
            return true;
        } else {
            return false;
        }
    }
}
