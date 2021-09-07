package flight.reservation.flight;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Schedule {

    private List<ScheduledFlight> scheduledFlights;


    public Schedule() {
        scheduledFlights = new ArrayList<>();
    }

    public List<ScheduledFlight> getScheduledFlights() {
        return scheduledFlights;
    }

    public void scheduleFlight(ScheduledFlight scheduledFlight){
        //ScheduledFlight scheduledFlight = new ScheduledFlight(flightRoute.getNumber(), flightRoute.getDeparture(), flightRoute.getArrival(), flightRoute.getAircraft(), date);
        scheduledFlights.add(scheduledFlight);
    }

    public void removeFlight(FlightRoute flightRoute) {
        List<ScheduledFlight> toBeRemoved = new ArrayList<>();
        for (ScheduledFlight scheduledFlight : scheduledFlights) {
            if (scheduledFlight.getFlightRoute() == flightRoute) {
                toBeRemoved.add(scheduledFlight);
            }
        }
        scheduledFlights.removeAll(toBeRemoved);
    }

    public void removeScheduledFlight(ScheduledFlight flight) {
        scheduledFlights.remove(flight);
    }

    public ScheduledFlight searchScheduledFlight(int flightNumber) {
        return scheduledFlights.stream()
                .filter(f -> f.getFlightRoute().getNumber() == flightNumber)
                .findFirst()
                .orElse(null);
    }

    public void clear() {
        scheduledFlights.clear();
    }
}
