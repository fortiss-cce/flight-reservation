package flight.reservation.flight;

import flight.reservation.Airport;
import flight.reservation.plane.Helicopter;
import flight.reservation.plane.PassengerDrone;
import flight.reservation.plane.PassengerPlane;
import flight.reservation.plane.Vehicle;

import java.util.Arrays;

public class Flight {

    private int number;
    private Airport departure;
    private Airport arrival;
    protected Vehicle aircraft;

    public Flight(int number, Airport departure, Airport arrival, Vehicle aircraft) throws IllegalArgumentException {
        this.number = number;
        this.departure = departure;
        this.arrival = arrival;
        this.aircraft = aircraft;
        checkValidity();
    }

    private void checkValidity() throws IllegalArgumentException {
        if (!isAircraftValid(departure) || !isAircraftValid(arrival)) {
            throw new IllegalArgumentException("Selected aircraft is not valid for the selected route.");
        }
    }

    private boolean isAircraftValid(Airport airport) {
        return Arrays.stream(airport.getAllowedAircrafts()).anyMatch(x -> {
            return x.equals(this.aircraft.getModel());
        });
    }

    public Vehicle getAircraft() {
        return aircraft;
    }

    public int getNumber() {
        return number;
    }

    public Airport getDeparture() {
        return departure;
    }

    public Airport getArrival() {
        return arrival;
    }

    @Override
    public String toString() {
        return aircraft.toString() + "-" + number + "-" + departure.getCode() + "/" + arrival.getCode();
    }

}
