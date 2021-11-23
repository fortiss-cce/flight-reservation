package flight.reservation.payment;

import java.util.HashMap;
import java.util.Map;

public class Paypal extends PaymentOption {
	public static final Map<String, String> DATA_BASE = new HashMap<>();

	private String email;
	private String password;

	static {
		DATA_BASE.put("amanda1985", "amanda@ya.com");
		DATA_BASE.put("qwerty", "john@amazon.eu");
	}

	public Paypal(String email, String password) {
		this.email = email;
		this.password = password;
	}

	@Override
	public boolean pay(double toPay) {
		if (email.equals(Paypal.DATA_BASE.get(password))) {
			System.out.println("Paying " + toPay + " using PayPal.");
			return true;
		} else {
			throw new IllegalStateException("Payment information is not set or not valid.");
		}
	}
}
