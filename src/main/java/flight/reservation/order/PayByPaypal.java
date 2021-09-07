//package flight.reservation.order;

import flight.reservation.order.PaymentStrategy;
import flight.reservation.order.FlightOrder;
import flight.reservation.order.Order;
import flight.reservation.payment.Paypal;

public class PayByPaypal implements PaymentStrategy {
  @Override
  public boolean isValid(CreditCard card) {
      return card != null && card.isValid();
  }

  @Override
  public boolean pay(String email, String password) throws IllegalStateException
  {
      if (this.thisOrder.isClosed()) {
          // Payment is already proceeded
          return true;
      }
      // validate payment information
      if (email == null || password == null || !email.equals(Paypal.DATA_BASE.get(password))) {
          throw new IllegalStateException("Payment information is not set or not valid.");
      }
      amount = this.thisOrder.getPrice();
      boolean isPaid = True;
      System.out.println("Paying " + amount + " using PayPal.");
      if (isPaid) {
          this.thisOrder.setClosed();
      }
      return isPaid;
  }
}
