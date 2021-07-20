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
        List<ScheduledFlight> toBeRemovedFlights = new ArrayList<>();
        for (ScheduledFlight scheduledFlight : scheduledFlights) {
            if (checkIsToBeRemoved(flight, scheduledFlight)) {
                toBeRemovedFlights.add(scheduledFlight);
            }
        }
        scheduledFlights.removeAll(toBeRemovedFlights);
    }

    private boolean checkIsToBeRemoved(Flight flight, ScheduledFlight scheduledFlight) {
       return (scheduledFlight == flight ||
               (flight.getArrival() == scheduledFlight.getArrival() &&
                       flight.getDeparture() == scheduledFlight.getDeparture() &&
                       flight.getNumber() == scheduledFlight.getNumber()));
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
