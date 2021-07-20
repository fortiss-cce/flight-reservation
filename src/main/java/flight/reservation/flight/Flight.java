package flight.reservation.flight;

import flight.reservation.Airport;
import flight.reservation.plane.AAircraft;

public class Flight {

    private int number;
    private Airport departure;
    private Airport arrival;
    protected AAircraft aircraft;

    public Flight(int number, Airport departure, Airport arrival, AAircraft aircraft) throws IllegalArgumentException {
        this.number = number;
        this.departure = departure;
        this.arrival = arrival;
        this.aircraft = aircraft;
        checkValidity();
    }

    private void checkValidity() throws IllegalArgumentException {
        if (departure.isForbiddenAircraft(aircraft) || arrival.isForbiddenAircraft(aircraft)) {
            throw new IllegalArgumentException("Selected aircraft is not valid for the selected route.");
        }
    }

    public AAircraft getAircraft() {
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

    public boolean equals(Flight flight) {
        return this == flight ||
                (getArrival() == flight.getArrival()
                        && getDeparture() == flight.getDeparture()
                        && getNumber() == flight.getNumber()
                );
    }

}
