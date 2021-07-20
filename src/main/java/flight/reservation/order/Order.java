package flight.reservation.order;

import flight.reservation.Customer;
import flight.reservation.Passenger;
import flight.reservation.flight.ScheduledFlight;
import flight.reservation.payment.CreditCard;
import flight.reservation.payment.Paypal;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Order {

    private final UUID id;
    private double price;
    private boolean isClosed = false;
    private Customer customer;
    private List<Passenger> passengers;

    public Order() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed() {
        isClosed = true;
    }

    public boolean isOrderValid(Customer customer, List<String> passengerNames, List<ScheduledFlight> flights) {
        //To be implemented in subclasses.
        return true;
    }

    public boolean processOrderWithCreditCardDetail(String number, Date expirationDate, String cvv) throws IllegalStateException {
        CreditCard creditCard = new CreditCard(number, expirationDate, cvv);
        return processOrderWithCreditCard(creditCard);
    }

    public boolean processOrderWithCreditCard(CreditCard creditCard) throws IllegalStateException {
        if (isClosed()) {
            // Payment is already proceeded
            return true;
        }
        // validate payment information
        if (!cardIsPresentAndValid(creditCard)) {
            throw new IllegalStateException("Payment information is not set or not valid.");
        }
        boolean isPaid = payWithCreditCard(creditCard, this.getPrice());
        if (isPaid) {
            this.setClosed();
        }
        return isPaid;
    }

    private boolean cardIsPresentAndValid(CreditCard card) {
        return card != null && card.isValid();
    }

    public boolean processOrderWithPayPal(String email, String password) throws IllegalStateException {
        if (isClosed()) {
            // Payment is already proceeded
            return true;
        }
        // validate payment information
        if (email == null || password == null || !email.equals(Paypal.DATA_BASE.get(password))) {
            throw new IllegalStateException("Payment information is not set or not valid.");
        }
        boolean isPaid = payWithPayPal(email, password, this.getPrice());
        if (isPaid) {
            this.setClosed();
        }
        return isPaid;
    }

    public boolean payWithCreditCard(CreditCard card, double amount) throws IllegalStateException {
        if (cardIsPresentAndValid(card)) {
            System.out.println("Paying " + getPrice() + " using Credit Card.");
            double remainingAmount = card.getAmount() - getPrice();
            if (remainingAmount < 0) {
                System.out.printf("Card limit reached - Balance: %f%n", remainingAmount);
                throw new IllegalStateException("Card limit reached");
            }
            card.setAmount(remainingAmount);
            return true;
        } else {
            return false;
        }
    }

    public boolean payWithPayPal(String email, String password, double amount) throws IllegalStateException {
        if (email.equals(Paypal.DATA_BASE.get(password))) {
            System.out.println("Paying " + getPrice() + " using PayPal.");
            return true;
        } else {
            return false;
        }
    }
}
