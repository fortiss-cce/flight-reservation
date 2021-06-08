package flight.reservation.flight;

import flight.reservation.Passenger;
import flight.reservation.plane.Helicopter;
import flight.reservation.plane.PassengerDrone;
import flight.reservation.plane.PassengerPlane;

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

    public int getCrewMemberCapacity() throws NoSuchFieldException {
        if (connection.getAircraft() instanceof PassengerPlane) {
            return ((PassengerPlane) connection.getAircraft()).crewCapacity;
        }
        if (connection.getAircraft() instanceof Helicopter) {
            return 2;
        }
        if (connection.getAircraft() instanceof PassengerDrone) {
            return 0;
        }
        throw new NoSuchFieldException("this aircraft has no information about its crew capacity");
    }

    public void addPassengers(List<Passenger> passengers) {
        this.passengers.addAll(passengers);
    }

    public void removePassengers(List<Passenger> passengers) {
        this.passengers.removeAll(passengers);
    }

    public int getCapacity() throws NoSuchFieldException {
        if (connection.getAircraft() instanceof PassengerPlane) {
            return ((PassengerPlane) connection.getAircraft()).passengerCapacity;
        }
        if (connection.getAircraft() instanceof Helicopter) {
            return ((Helicopter) connection.getAircraft()).getPassengerCapacity();
        }
        if (connection.getAircraft() instanceof PassengerDrone) {
            return 4;
        }
        throw new NoSuchFieldException("this aircraft has no information about its capacity");
    }

    public int getAvailableCapacity() throws NoSuchFieldException {
        return this.getCapacity() - this.passengers.size();
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
