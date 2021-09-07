package flight.reservation;

import flight.reservation.plane.AircraftFactory;
import java.util.ArrayList;

public class Airport {

    private final String code;
    private ArrayList<String> allowedAircrafts;

    public Airport(String code) {
        this.code = code;
        this.allowedAircrafts = AircraftFactory.getAllowedModels();
    }

    public Airport(String code, ArrayList<String> allowedAircrafts) {
        this.code = code;
        this.allowedAircrafts = allowedAircrafts;
    }

    public String getCode() {
        return code;
    }

    public ArrayList<String> getAllowedAircrafts() {
        return allowedAircrafts;
    }
}
