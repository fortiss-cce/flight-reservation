package flight.reservation.flight;

import flight.reservation.Airport;
import flight.reservation.Passenger;
import flight.reservation.plane.Aircraft;
import flight.reservation.plane.Helicopter;
import flight.reservation.plane.PassengerDrone;
import flight.reservation.plane.PassengerPlane;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduledFlight {

    private Flight flight;
    private final List<Passenger> passengers;
    private final Date departureTime;
    private double currentPrice;

    public ScheduledFlight(Flight flight, Date departureTime, double currentPrice) {
        this.flight = flight;
        this.departureTime = departureTime;
        this.passengers = new ArrayList<>();
        this.currentPrice = currentPrice;
    }

    public ScheduledFlight(Flight flight, Date departureTime) {
        this(flight, departureTime, 100);
    }

    public int getCrewMemberCapacity() throws NoSuchFieldException {
        return this.getFlight().getCrewCapacity();
    }

    public void addPassengers(List<Passenger> passengers) {
        this.passengers.addAll(passengers);
    }

    public void removePassengers(List<Passenger> passengers) {
        this.passengers.removeAll(passengers);
    }

    public int getCapacity() throws NoSuchFieldException {
        return this.getFlight().getPassengerCapacity();
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

    public Flight getFlight() {
        return this.flight;
    }

    public int getNumber() {
        return this.getFlight().getNumber();
    }

    public Airport getArrival() {
        return this.getFlight().getArrival();
    }

    public Airport getDeparture() {
        return this.getFlight().getDeparture();
    }
}
