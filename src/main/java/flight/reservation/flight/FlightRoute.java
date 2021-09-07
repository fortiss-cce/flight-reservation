package flight.reservation.flight;
import flight.reservation.Airport;

public class FlightRoute {

    private int number;
    private Airport departure;
    private Airport arrival;

    public FlightRoute(int number, Airport departure, Airport arrival) {
        this.number = number;
        this.departure = departure;
        this.arrival = arrival;
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
        return number + "-" + departure.getCode() + "/" + arrival.getCode();
    }

}
