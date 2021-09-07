package flight.reservation.order;

import flight.reservation.Customer;
import flight.reservation.flight.ScheduledFlight;
import flight.reservation.payment.CreditCard;
import flight.reservation.payment.Paypal;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FlightOrder extends Order {
    private final List<ScheduledFlight> flights;
    static List<String> noFlyList = Arrays.asList(); //you get another chance ;)

    public FlightOrder(List<ScheduledFlight> flights) {
        this.flights = flights;
    }

    public static List<String> getNoFlyList() {
        return noFlyList;
    }

    public List<ScheduledFlight> getScheduledFlights() {
        return flights;
    }

    private boolean isOrderValid(Customer customer, List<String> passengerNames, List<ScheduledFlight> flights) {
        boolean valid = true;
        valid = valid && !noFlyList.contains(customer.getName());
        valid = valid && passengerNames.stream().noneMatch(passenger -> noFlyList.contains(passenger));
        valid = valid && flights.stream().allMatch(scheduledFlight -> {
            try {
                return scheduledFlight.getAvailableCapacity() >= passengerNames.size();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                return false;
            }
        });
        return valid;
    }

    public boolean processOrderWithCreditCardDetail(String number, Date expirationDate, String cvv) throws IllegalStateException {
        CreditCard creditCard = new CreditCard(number, expirationDate, cvv);
        return processOrderWithCreditCard(creditCard);
    }

    public interface PaymentStrategy {
        boolean isValid();
        boolean pay(double amount);
        //boolean process();
    }

    public class PayByCreditCard implements PaymentStrategy {

        private CreditCard card;

        public PayByCreditCard(CreditCard creditCard) {
            this.card = creditCard;
        }

        @Override
        public boolean isValid() {
            return this.card != null && this.card.isValid();
        }

        @Override
        public boolean pay(double amount) throws IllegalStateException {
            if (this.isValid()) {
                System.out.println("Paying " + getPrice() + " using Credit Card.");
                double remainingAmount = this.card.getAmount() - getPrice();
                if (remainingAmount < 0) {
                    System.out.printf("Card limit reached - Balance: %f%n", remainingAmount);
                    throw new IllegalStateException("Card limit reached");
                }
                this.card.setAmount(remainingAmount);
                return true;
            } else {
                return false;
            }
        }
    }

    public class PayByPayPal implements PaymentStrategy {

        private String email;
        private String password;

        public PayByPayPal(String email, String password) {
            this.email = email;
            this.password = password;
        }

        @Override
        public boolean isValid() {
            return email != null && password != null && this.email.equals(Paypal.DATA_BASE.get(this.password));
        }

        @Override
        public boolean pay(double amount) throws IllegalStateException {
            if (this.isValid()) {
                System.out.println("Paying " + getPrice() + " using PayPal.");
                return true;
            } else {
                return false;
            }
        }
    }


    public boolean processOrderWithCreditCard(CreditCard creditCard) throws IllegalStateException {
        PayByCreditCard payByCreditCard = new PayByCreditCard(creditCard);
        if (isClosed()) {
            // Payment is already proceeded
            return true;
        }
        // validate payment information
        if (!payByCreditCard.isValid()) {
            throw new IllegalStateException("Payment information is not set or not valid.");
        }
        boolean isPaid = payByCreditCard.pay(this.getPrice());
        if (isPaid) {
            this.setClosed();
        }
        return isPaid;
    }

    public boolean processOrderWithPayPal(String email, String password) throws IllegalStateException {

        PayByPayPal payByPayPal = new PayByPayPal(email, password);
        if (isClosed()) {
            // Payment is already proceeded
            return true;
        }
        // validate payment information
        if (!payByPayPal.isValid()) {
            throw new IllegalStateException("Payment information is not set or not valid.");
        }
        boolean isPaid = payByPayPal.pay(this.getPrice());
        if (isPaid) {
            this.setClosed();
        }
        return isPaid;
    }

    public static boolean isNameOnNoFlyList(String name) {
        return FlightOrder.getNoFlyList().contains(name);
    }

}
