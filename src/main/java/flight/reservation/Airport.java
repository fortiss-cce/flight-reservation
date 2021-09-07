package flight.reservation;

import flight.reservation.flight.Flight;
import flight.reservation.plane.AircraftFactory;

import java.util.ArrayList;
import java.util.List;

public class Airport {

    private final String name;
    private final String code;
    private final String location;
    private List<Flight> flights;
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

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public ArrayList<String> getAllowedAircrafts() {
        return allowedAircrafts;
    }
}
