import flight.reservation.Airport;
import flight.reservation.flight.FlightRoute;
import flight.reservation.flight.Schedule;

import java.util.Arrays;
import java.util.List;

public class Runner {
    static List<Airport> airports = Arrays.asList(
            new Airport( "BER"),
            new Airport("FRA"),
            new Airport("MAD"),
            new Airport("GRU"),
            new Airport("JFK"),
            new Airport("IST"),
            new Airport("DXB"),
            new Airport("CTU")
    );

    static List<FlightRoute> flightRoutes = Arrays.asList(
            new FlightRoute(1, airports.get(0), airports.get(1)),
            new FlightRoute(2, airports.get(1), airports.get(2)),
            new FlightRoute(3, airports.get(2), airports.get(4)),
            new FlightRoute(4, airports.get(3), airports.get(2)),
            new FlightRoute(5, airports.get(4), airports.get(2)),
            new FlightRoute(6, airports.get(5), airports.get(7))
    );

    static Schedule schedule;

    public static void main(String[] args) {
    }
}
