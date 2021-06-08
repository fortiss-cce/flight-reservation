package flight.reservation;

import flight.reservation.flight.Connection;
import flight.reservation.plane.AircraftModel;

import java.util.List;

public class Airport {

    private final String name;
    private final String code;
    private final String location;
    private List<Connection> flights;
    private AircraftModel[] allowedAircraftModels;

    public Airport(String name, String code, String location) {
        this.name = name;
        this.code = code;
        this.location = location;
        this.allowedAircraftModels = new AircraftModel[]{
                AircraftModel.A380,
                AircraftModel.A350,
                AircraftModel.Embraer190,
                AircraftModel.AntonovAN2,
                AircraftModel.H1,
                AircraftModel.H2,
                AircraftModel.HypaHype};
    }

    public Airport(String name, String code, String location, AircraftModel[] allowedAircraftModels) {
        this.name = name;
        this.code = code;
        this.location = location;
        this.allowedAircraftModels = allowedAircraftModels;
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

    public AircraftModel[] getAllowedAircraftModels() {
        return allowedAircraftModels;
    }
}
