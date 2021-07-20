package flight.reservation.payment;

public abstract class APaymentMethod {
    public abstract boolean pay(double amount);
    public abstract boolean isValid();
}
