package flight.reservation.payment;
import flight.reservation.payment.PaymentStrategy;

import java.util.Date;

/**
 * Dummy credit card class.
 */
public class CreditCard extends PaymentStrategy{
    private double amount;

    public CreditCard(String number, Date date, String cvv) {
        this.amount = 100000;
        this.loginUsername = number;
        this.date = date;
        this.loginSecret = cvv;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public boolean isValid() {
        return loginUsername.length() > 0 && date.getTime() > System.currentTimeMillis() && !cvv.equals("000");;
    }
    
    @Override
    public boolean pay(double amount) throws IllegalStateException {
        if (this.isValid()) {
            System.out.println("Paying " + amount + " using Credit Card.");
            double remainingAmount = this.getAmount() - amount;
            if (remainingAmount < 0) {
                System.out.printf("Card limit reached - Balance: %f%n", remainingAmount);
                throw new IllegalStateException("Card limit reached");
            }
            this.setAmount(remainingAmount);
            return true;
        } else {
            return false;
        }
    }

}