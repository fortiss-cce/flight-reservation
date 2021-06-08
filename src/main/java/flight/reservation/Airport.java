package flight.reservation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import flight.reservation.flight.Flight;
import flight.reservation.plane.Aircraft;
import flight.reservation.plane.AircraftFactory;

public class Airport {

    private final String name;
    private final String code;
    private final String location;
    private List<Flight> flights;
    private Set<String> allowedAircrafts;

    public Airport(String name, String code, String location) {
        this.name = name;
        this.code = code;
        this.location = location;
        this.allowedAircrafts = AircraftFactory.allAircraftTypes();
    }

    public Airport(String name, String code, String location, String[] allowedAircrafts) {
        this.name = name;
        this.code = code;
        this.location = location;
        this.allowedAircrafts = new HashSet<>();
        this.allowedAircrafts.addAll(Arrays.asList(allowedAircrafts));
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

    public boolean isAllowedAircraft(Aircraft aircraft){
        return this.allowedAircrafts.contains(aircraft.getModel());
    }
}
