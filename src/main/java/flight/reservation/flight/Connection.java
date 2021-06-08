package flight.reservation.flight;

import flight.reservation.Airport;
import flight.reservation.plane.AircraftModel;

import java.util.Arrays;
import java.util.Objects;

public class Connection {

    private final int number;
    private final Airport departure;
    private final Airport arrival;
    private final AircraftModel aircraftModel;

    public Connection(int number, Airport departure, Airport arrival, AircraftModel aircraftModel) throws IllegalArgumentException {
        this.number = number;
        this.departure = departure;
        this.arrival = arrival;
        this.aircraftModel = aircraftModel;
        checkValidity();
    }

    private void checkValidity() throws IllegalArgumentException {
        if (!departure.isAircraftValid(aircraftModel) || !arrival.isAircraftValid(aircraftModel)) {
            throw new IllegalArgumentException("Selected aircraft is not valid for the selected route.");
        }
    }

    public AircraftModel getAircraftModel() {
        return aircraftModel;
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
        Connection that = (Connection) o;
        return number == that.number && departure.equals(that.departure) && arrival.equals(that.arrival) && aircraftModel.equals(that.aircraftModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, departure, arrival, aircraftModel);
    }

    @Override
    public String toString() {
        return aircraftModel.toString() + "-" + number + "-" + departure.getCode() + "/" + arrival.getCode();
    }

}
