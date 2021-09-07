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
        scheduledFlights.add(new ScheduledFlight(flight, date));
    }

    public void removeFlight(Flight flight) {
        List<ScheduledFlight> tbr = new ArrayList<>();
        for (ScheduledFlight scheduledFlight : scheduledFlights) {
            Flight flightInSchedule = scheduledFlight.getFlight();
            if (flightInSchedule == flight ||
                (flight.getArrival() == flightInSchedule.getArrival() &&
                 flight.getDeparture() == flightInSchedule.getDeparture() &&
                 flight.getNumber() == flightInSchedule.getNumber())) {
                tbr.add(scheduledFlight);
            }
        }
        scheduledFlights.removeAll(tbr);
    }

    public void removeScheduledFlight(ScheduledFlight flight) {
        scheduledFlights.remove(flight);
    }

    public ScheduledFlight searchScheduledFlight(int flightNumber) {
        return scheduledFlights.stream()
                .filter(f -> f.getFlight().getNumber() == flightNumber)
                .findFirst()
                .orElse(null);
    }

    public void clear() {
        scheduledFlights.clear();
    }
}
