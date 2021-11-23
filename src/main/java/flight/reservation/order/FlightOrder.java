package flight.reservation.order;

import java.util.Arrays;
import java.util.List;

import flight.reservation.Customer;
import flight.reservation.flight.ScheduledFlight;
import flight.reservation.payment.CreditCard;
import flight.reservation.payment.PaymentOption;
import flight.reservation.payment.Paypal;

public class FlightOrder extends Order {
	private final List<ScheduledFlight> flights;
	static List<String> noFlyList = Arrays.asList("Peter", "Johannes");

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

	public boolean processOrder(PaymentOption paymentOption) throws IllegalStateException {
		if (isClosed()) {
			// Payment is already proceeded
			return true;
		}
		boolean isPaid = paymentOption.pay(this.getPrice());
		if (isPaid) {
			this.setClosed();
		}
		return isPaid;
	}

	public boolean processOrderWithCreditCard(CreditCard creditCard) throws IllegalStateException {
		return processOrder(creditCard);
	}

	public boolean processOrderWithPayPal(String email, String password) throws IllegalStateException {
		return processOrder(new Paypal(email, password));
	}
}
