package flight.reservation.flight;

import flight.reservation.Airport;
import flight.reservation.plane.AbstractPlane;
import flight.reservation.plane.Helicopter;
import flight.reservation.plane.PassengerDrone;
import flight.reservation.plane.PassengerPlane;

import java.util.Arrays;
import java.util.Objects;

public class Flight {

    private int number;
    private Airport departure;
    private Airport arrival;
    protected Object aircraft;

    public Flight(int number, Airport departure, Airport arrival, Object aircraft) throws IllegalArgumentException {
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
            AbstractPlane plane = (AbstractPlane)this.aircraft;
            // TODO: throw new IllegalArgumentException(String.format("Aircraft is not recognized"));
            return x.equals(plane.getModel());
        });
    }

    public Object getAircraft() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight1 = (Flight) o;
        return number == flight1.number &&
                departure.equals(flight1.departure) &&
                arrival.equals(flight1.arrival);
    }
    @Override
    public int hashCode() {
        return Objects.hash(number, departure, arrival);
    }

    @Override
    public String toString() {
        return aircraft.toString() + "-" + number + "-" + departure.getCode() + "/" + arrival.getCode();
    }

}
