package flight.reservation;

import flight.reservation.flight.Connection;

import java.util.List;

public class Airport {

    private final String name;
    private final String code;
    private final String location;
    private List<Connection> flights;
    private String[] allowedAircrafts;

    public Airport(String name, String code, String location) {
        this.name = name;
        this.code = code;
        this.location = location;
        // TODO: Should also use plane type
        this.allowedAircrafts = new String[]{"A380", "A350", "Embraer 190", "Antonov AN2", "H1", "H2", "HypaHype"};
    }

    public Airport(String name, String code, String location, String[] allowedAircrafts) {
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

    public List<Connection> getFlights() {
        return flights;
    }

    public void setFlights(List<Connection> flights) {
        this.flights = flights;
    }

    public String[] getAllowedAircrafts() {
        return allowedAircrafts;
    }
}
