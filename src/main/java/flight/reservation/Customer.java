package flight.reservation;

import flight.reservation.flight.ScheduledFlight;
import flight.reservation.order.FlightOrder;
import flight.reservation.order.Order;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String email;
    private String name;
    private List<Order> orders;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    public FlightOrder createOrder(List<String> passengerNames,
                                   List<ScheduledFlight> flights,
                                   double price) {

        FlightOrder order = FlightOrder.create(this, passengerNames, flights, price);
        this.orders.add(order);
        return order;
	}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}
