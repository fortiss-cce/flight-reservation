
public interface PaymentStrategy {
    boolean isValid();
    boolean pay(double amount) throws IllegalStateException;
}
