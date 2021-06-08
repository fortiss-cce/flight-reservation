package flight.reservation.flight;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Schedule {

    private List<ScheduledFlight> scheduledFlights;

    public Schedule() {
        this.scheduledFlights = new ArrayList<>();
    }

    public List<ScheduledFlight> getScheduledFlights() {
        return scheduledFlights;
    }

    public void scheduleFlight(Connection connection, Date date) {
        ScheduledFlight scheduledFlight = new ScheduledFlight(connection, date);
        scheduledFlights.add(scheduledFlight);
    }

    public void removeScheduledFlight(ScheduledFlight flight) {
        scheduledFlights.remove(flight);
    }

    public void removeAllScheduledFlights(Connection connection) {
        List<ScheduledFlight> toBeRemoved = scheduledFlights
                .stream()
                .filter(scheduledFlight -> scheduledFlight.getConnection().equals(connection))
                .collect(Collectors.toList());

        scheduledFlights.removeAll(toBeRemoved);
    }

    public ScheduledFlight searchScheduledFlight(int flightNumber) {
        return scheduledFlights.stream()
                .filter(f -> f.getConnection().getNumber() == flightNumber)
                .findFirst()
                .orElse(null);
    }

    public void clear() {
        scheduledFlights.clear();
    }
}
