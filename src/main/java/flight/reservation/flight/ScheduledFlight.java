package flight.reservation.flight;

import flight.reservation.Airport;
import flight.reservation.Passenger;
import flight.reservation.plane.Helicopter;
import flight.reservation.plane.PassengerDrone;
import flight.reservation.plane.PassengerPlane;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduledFlight {

    private final List<Passenger> passengers;
    private final Date departureTime;
    private double currentPrice = 100;
    private final Flight flight;

    public ScheduledFlight(int number, Airport departure, Airport arrival, Object aircraft, Date departureTime) {
        this.flight = new Flight(number, departure, arrival, aircraft);
        this.departureTime = departureTime;
        this.passengers = new ArrayList<>();
    }

    public ScheduledFlight(int number, Airport departure, Airport arrival, Object aircraft, Date departureTime, double currentPrice) {
        this.flight = new Flight(number, departure, arrival, aircraft);
        this.departureTime = departureTime;
        this.passengers = new ArrayList<>();
        this.currentPrice = currentPrice;
    }

    public int getCrewMemberCapacity() throws NoSuchFieldException {
        Object aircraft = this.flight.aircraft;
        if (aircraft instanceof PassengerPlane) {
            return ((PassengerPlane) aircraft).crewCapacity;
        }
        if (aircraft instanceof Helicopter) {
            return 2;
        }
        if (aircraft instanceof PassengerDrone) {
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
        Object aircraft = this.flight.aircraft;
        if (aircraft instanceof PassengerPlane) {
            return ((PassengerPlane) aircraft).passengerCapacity;
        }
        if (aircraft instanceof Helicopter) {
            return ((Helicopter) aircraft).getPassengerCapacity();
        }
        if (aircraft instanceof PassengerDrone) {
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
