//package flight.reservation.order;

import flight.reservation.order.PaymentStrategy;
import flight.reservation.order.FlightOrder;
import flight.reservation.order.Order;
import flight.reservation.payment.CreditCard;

public class PayByCreditCard implements PaymentStrategy {
    private Order thisOrder;

    public PayByCreditCard(Order anOrder)
    {
        this.thisOrder = anOrder;
    }

    @Override
    public boolean isValid(CreditCard card) {
        return card != null && card.isValid();
    }

    @Override
    public boolean pay(CreditCard card) throws IllegalStateException {
        if (this.thisOrder.isClosed()) {
            // Payment is already proceeded
            return true;
        }
        if (this.isValid(card)) {
            amount = this.thisOrder.getPrice();
            System.out.println("Paying " + amount + " using Credit Card.");
            double remainingAmount = card.getAmount() - amount;
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
}
