package flight.reservation;

import flight.reservation.flight.FlightRoute;
import flight.reservation.plane.AircraftFactory;

import java.util.ArrayList;
import java.util.List;

public class Airport {

    private final String name;
    private final String code;
    private final String location;
    private List<FlightRoute> flightRoutes;
    private ArrayList<String> allowedAircrafts;

    public Airport(String name, String code, String location) {
        this.name = name;
        this.code = code;
        this.location = location;
        this.allowedAircrafts = AircraftFactory.getAllowedModels();
    }

    public Airport(String name, String code, String location, ArrayList<String> allowedAircrafts) {
        this.name = name;
        this.code = code;
        this.location = location;
        this.allowedAircrafts = allowedAircrafts;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getLocation() {
        return location;
    }

    public List<FlightRoute> getFlights() {
        return flightRoutes;
    }

    public void setFlights(List<FlightRoute> flightRoutes) {
        this.flightRoutes = flightRoutes;
    }

    public ArrayList<String> getAllowedAircrafts() {
        return allowedAircrafts;
    }
}
