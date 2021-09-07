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

    public void scheduleFlight(Flight flight, Date date) {
        ScheduledFlight scheduledFlight = new ScheduledFlight(flight.getNumber(), flight.getDeparture(), flight.getArrival(), flight.getAircraft(), date);
        scheduledFlights.add(scheduledFlight);
    }

    public void removeFlight(Flight flight) {
        List<ScheduledFlight> flightsToBeRemoved = new ArrayList<>();
        for (ScheduledFlight scheduledFlight : scheduledFlights) {
            if (scheduledFlight.getFlight() == flight ||
                    flight.isSameFlight(scheduledFlight.getFlight())) {
                flightsToBeRemoved.add(scheduledFlight);
            }
        }
        scheduledFlights.removeAll(flightsToBeRemoved);
    }

    public void removeScheduledFlight(ScheduledFlight flight) {
        scheduledFlights.remove(flight);
    }

    public ScheduledFlight searchScheduledFlight(int flightNumber) {
        return scheduledFlights.stream()
                .filter(f -> f.getNumber() == flightNumber)
                .findFirst()
                .orElse(null);
    }

    public void clear() {
        scheduledFlights.clear();
    }
}
