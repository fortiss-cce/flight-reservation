package flight.reservation.flight;

import flight.reservation.Passenger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduledFlight {

    private final Connection connection;
    private final List<Passenger> passengers;
    private final Date departureTime;
    private double currentPrice = 100;

    public ScheduledFlight(Connection connection, Date departureTime) {
        this.connection = connection;
        this.departureTime = departureTime;
        this.passengers = new ArrayList<>();
    }

    public ScheduledFlight(Connection connection, Date departureTime, double currentPrice) {
        this(connection, departureTime);
        this.currentPrice = currentPrice;
    }

    public Connection getConnection() {
        return connection;
    }

    public void addPassengers(List<Passenger> passengers) {
        this.passengers.addAll(passengers);
    }

    public void removePassengers(List<Passenger> passengers) {
        this.passengers.removeAll(passengers);
    }

    public int getAvailableCapacity() {
        return connection.getAircraftModel().getMaxPassengerCapacity() - this.passengers.size();
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }
}
