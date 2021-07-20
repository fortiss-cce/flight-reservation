package flight.reservation;

import flight.reservation.flight.Flight;
import flight.reservation.plane.AAircraft;

import java.util.List;

public class Airport {

    private final String name;
    private final String code;
    private final String location;
    private List<Flight> flights;
    private String[] allowedAircraftModels;

    public Airport(String name, String code, String location) {
        this.name = name;
        this.code = code;
        this.location = location;
        //TODO replace hardcoded types
        this.allowedAircraftModels = new String[]{"A380", "A350", "Embraer 190", "Antonov AN2", "H1", "H2", "HypaHype"};
    }

    public Airport(String name, String code, String location, String[] allowedAircrafts) {
        this.name = name;
        this.code = code;
        this.location = location;
        this.allowedAircraftModels = allowedAircrafts;
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

    public String[] getAllowedAircraftModels() {
        return allowedAircraftModels;
    }

    public boolean isForbiddenAircraft(AAircraft aircraft) {
        for (String allowedAircraftModel : allowedAircraftModels) {
            if (aircraft.getModel().equals(allowedAircraftModel)) {
                return false;
            }
        }
        return true;
    }
}
