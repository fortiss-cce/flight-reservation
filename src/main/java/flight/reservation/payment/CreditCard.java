package flight.reservation.payment;

import flight.reservation.order.FlightOrder;

import java.util.Date;

/**
 * Dummy credit card class.
 */
public class CreditCard extends Payment {
    private final String number;
    private final Date date;
    private final String cvv;
    private boolean valid;

    public CreditCard(String number, Date date, String cvv) {
        super();
        this.number = number;
        this.date = date;
        this.cvv = cvv;
        this.setValid();
    }

    public boolean processOrder(FlightOrder flightOrder) throws IllegalStateException {
        if (flightOrder.isClosed()) {
            // Payment is already proceeded
            return true;
        }
        // validate payment information
        if (!isValid()) {
            throw new IllegalStateException("Payment information is not set or not valid.");
        }
        boolean isPaid = pay(flightOrder, flightOrder.getPrice());
        if (isPaid) {
            flightOrder.setClosed();
        }
        return isPaid;
    }

    public boolean pay(FlightOrder flightOrder, double amount) throws IllegalStateException {
        if (isValid()) {
            System.out.println("Paying " + flightOrder.getPrice() + " using Credit Card.");
            double remainingAmount = getAmount() - flightOrder.getPrice();
            if (remainingAmount < 0) {
                System.out.printf("Card limit reached - Balance: %f%n", remainingAmount);
                throw new IllegalStateException("Card limit reached");
            }
            setAmount(remainingAmount);
            return true;
        } else {
            return false;
        }
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid() {
        // Dummy validation
        this.valid = number.length() > 0 && date.getTime() > System.currentTimeMillis() && !cvv.equals("000");
    }
}