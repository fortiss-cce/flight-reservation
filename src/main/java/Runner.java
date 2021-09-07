import flight.reservation.Airport;
import flight.reservation.flight.FlightRoute;
import flight.reservation.flight.Schedule;
import flight.reservation.plane.Aircraft;
import flight.reservation.plane.AircraftFactory;

import java.util.Arrays;
import java.util.List;

public class Runner {
    static List<Airport> airports = Arrays.asList(
            new Airport("Berlin Airport", "BER", "Berlin, Berlin"),
            new Airport("Frankfurt Airport", "FRA", "Frankfurt, Hesse"),
            new Airport("Madrid Barajas Airport", "MAD", "Barajas, Madrid"),
            new Airport("Guarulhos International Airport", "GRU", "Guarulhos (São Paulo)"),
            new Airport("John F. Kennedy International Airport", "JFK", "Queens, New York, New York"),
            new Airport("Istanbul Airport", "IST", "Arnavutköy, Istanbul"),
            new Airport("Dubai International Airport", "DXB", "Garhoud, Dubai"),
            new Airport("Chengdu Shuangliu International Airport", "CTU", "Shuangliu-Wuhou, Chengdu, Sichuan")
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
