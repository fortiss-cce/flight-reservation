package flight.reservation.flight;

import flight.reservation.Airport;
import flight.reservation.plane.Aircraft;

public class Flight {

    private int number;
    private Airport departure;
    private Airport arrival;
    protected Aircraft aircraft;

    public Flight(int number, Airport departure, Airport arrival, Aircraft aircraft) throws IllegalArgumentException {
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

        for (String allowedAircraft : airport.getAllowedAircrafts()) {
            String model = this.aircraft.getModel();
            if (allowedAircraft.equals(model)){
                return true;
            }
        }
        return false;
    }

    public Aircraft getAircraft() {
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
