package flight.reservation.flight;

import flight.reservation.Airport;
import flight.reservation.Passenger;
import flight.reservation.plane.Aircraft;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduledFlight {

    private final List<Passenger> passengers;
    private final Date departureTime;
    private FlightRoute flightRoute;
    private double currentPrice = 100;
    protected Aircraft aircraft;

    public ScheduledFlight(FlightRoute flightRoute, Aircraft aircraft, Date departureTime)
            throws IllegalArgumentException {
        this.flightRoute = flightRoute;
        this.aircraft = aircraft;
        this.departureTime = departureTime;
        this.passengers = new ArrayList<>();
        checkValidity();
    }

    public ScheduledFlight(FlightRoute flightRoute, Aircraft aircraft, Date departureTime,
                           double currentPrice) throws IllegalArgumentException {
        this.flightRoute = flightRoute;
        this.aircraft = aircraft;
        this.departureTime = departureTime;
        this.passengers = new ArrayList<>();
        this.currentPrice = currentPrice;
        checkValidity();
    }

    public void addPassengers(List<Passenger> passengers) {
        this.passengers.addAll(passengers);
    }

    public void removePassengers(List<Passenger> passengers) {
        this.passengers.removeAll(passengers);
    }

    public int getCapacity() throws NoSuchFieldException {
        return this.aircraft.getPassengerCapacity();
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

    private boolean isAircraftValid(Airport airport) {
        return airport.getAllowedAircrafts().contains(this.aircraft.getModel());
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public FlightRoute getFlightRoute(){
        return this.flightRoute;
    }

    private void checkValidity() throws IllegalArgumentException {
        if (!isAircraftValid(this.flightRoute.getDeparture()) || !isAircraftValid(this.flightRoute.getArrival())) {
            throw new IllegalArgumentException("Selected aircraft is not valid for the selected route.");
        }
    }
}
