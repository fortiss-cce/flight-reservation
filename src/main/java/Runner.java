import flight.reservation.Airport;
import flight.reservation.flight.Schedule;
import flight.reservation.flight.Connection;
import flight.reservation.plane.AircraftModel;

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

    static List<Connection> flights = Arrays.asList(
            new Connection(1, airports.get(0), airports.get(1), AircraftModel.A380),
            new Connection(2, airports.get(1), airports.get(2), AircraftModel.A350),
            new Connection(3, airports.get(2), airports.get(4), AircraftModel.Embraer190),
            new Connection(4, airports.get(3), airports.get(2), AircraftModel.AntonovAN2),
            new Connection(5, airports.get(4), airports.get(2), AircraftModel.H1),
            new Connection(6, airports.get(5), airports.get(7), AircraftModel.HypaHype)
    );

    static Schedule schedule;

    public static void main(String[] args) {
    }
}
