package flight.reservation.payment;

public class Payment {
    private static final String PAYMENT_ERROR_MESSAGE = "Payment information is not set or not valid.";

    private static boolean cardIsPresentAndValid(CreditCard card) {
        return card != null && card.isValid();
    }

    public static boolean payWithCreditCard(CreditCard card, double amount) throws IllegalStateException {
        // validate payment information
        if (!cardIsPresentAndValid(card)) {
            throw new IllegalStateException(PAYMENT_ERROR_MESSAGE);
        }
        System.out.println("Paying " + amount + " using Credit Card.");
        double remainingAmount = card.getAmount() - amount;
        if (remainingAmount < 0) {
            System.out.printf("Card limit reached - Balance: %f%n", remainingAmount);
            throw new IllegalStateException("Card limit reached");
        }
        card.setAmount(remainingAmount);
        return true;
    }

    public static boolean payWithPayPal(String email, String password, double amount) throws IllegalStateException {
        if (email == null || password == null || !email.equals(Paypal.DATA_BASE.get(password))) {
            throw new IllegalStateException(PAYMENT_ERROR_MESSAGE);
        }
        if (email.equals(Paypal.DATA_BASE.get(password))) {
            System.out.println("Paying " + amount + " using PayPal.");
            return true;
        } else {
            return false;
        }
    }

}
