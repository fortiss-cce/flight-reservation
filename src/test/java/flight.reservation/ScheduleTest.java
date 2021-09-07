package flight.reservation;

import flight.reservation.flight.FlightRoute;
import flight.reservation.flight.Schedule;
import flight.reservation.flight.ScheduledFlight;
import flight.reservation.plane.Aircraft;
import flight.reservation.plane.AircraftFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Schedule Tests")
public class ScheduleTest {

    private Schedule schedule;

    @BeforeEach
    public void initSchedule() {
        schedule = new Schedule();
    }

    @Nested
    @DisplayName("Given an empty Schedule")
    class GivenAnEmptySchedule {

        @Test
        @DisplayName("then the size of the Schedule should be zero")
        void thenTheSizeOfTheScheduleShouldBeZero() {
            assertEquals(0, schedule.getScheduledFlights().size());
        }

        @Test
        @DisplayName("then the search for an unknown flight element should return null")
        void thenSearchForAnUnknownElementShouldReturnNull() {
            assertEquals(null, schedule.searchScheduledFlight(1337));
        }

        @Test
        @DisplayName("then the search for an known flight element should return null")
        void thenSearchForAnKnownElementShouldReturnNull() {
            assertEquals(null, schedule.searchScheduledFlight(1));
        }

        @Test
        @DisplayName("then removing a flight should still yield an empty list")
        void thenScheduleShouldYieldEmpty() {
            Aircraft aircraft = AircraftFactory.create("A380");
            schedule.removeFlight(new FlightRoute(1, new Airport("a"), new Airport("b")));
            assertEquals(0, schedule.getScheduledFlights().size());
        }

        @Nested
        @DisplayName("when a flight is scheduled")
        class WhenAFlightRouteIsScheduled {

            private FlightRoute flightRoute;
            private Date departure;

            @BeforeEach
            void scheduleOneFlight() {
                Airport startAirport = new Airport("BER");
                Airport destAirport = new Airport("FRA");

                Aircraft aircraft = AircraftFactory.create("A380");
                flightRoute = new FlightRoute(1, startAirport, destAirport);
                departure = TestUtil.addDays(Date.from(Instant.now()), 3);
                ScheduledFlight scheduledFlight = new ScheduledFlight(flightRoute, aircraft, departure);
                schedule.scheduleFlight(scheduledFlight);
            }

            @Test
            @DisplayName("then the schedule should not be empty anymore")
            void thenScheduleShouldContainOneElement() {
                assertEquals(1, schedule.getScheduledFlights().size());
            }

            @Test
            @DisplayName("then the correct flight should be scheduled")
            void thenScheduleShouldContainCorrectElement() {
                ScheduledFlight scheduledFlight = schedule.getScheduledFlights().get(0);
                assertEquals(flightRoute.getNumber(), scheduledFlight.getFlightRoute().getNumber());
                assertEquals(departure, scheduledFlight.getDepartureTime());
            }

            @Test
            @DisplayName("then the schedule should not be empty anymore")
            void thenSearchShouldReturnFlight() {
                ScheduledFlight scheduledFlight = schedule.getScheduledFlights().get(0);
                assertEquals(scheduledFlight, schedule.searchScheduledFlight(1));
            }

            @Test
            @DisplayName("then removing a flight should yield an empty list")
            void thenRemoveShouldYieldEmpty() {
                schedule.removeFlight(flightRoute);
                assertEquals(0, schedule.getScheduledFlights().size());
            }
        }
    }

    @Nested
    @DisplayName("Given an existing Schedule")
    class GivenAnExistingSchedule {
        List<Airport> airports = Arrays.asList(
                new Airport( "BER"),
                new Airport("FRA"),
                new Airport("MAD"),
                new Airport("GRU"),
                new Airport("JFK"),
                new Airport("IST"),
                new Airport("DXB"),
                new Airport("CTU")
        );

        List<FlightRoute> flightRoutes = Arrays.asList(
                new FlightRoute(1, airports.get(0), airports.get(1)),
                new FlightRoute(2, airports.get(1), airports.get(2)),
                new FlightRoute(3, airports.get(2), airports.get(4)),
                new FlightRoute(4, airports.get(3), airports.get(2)),
                new FlightRoute(5, airports.get(4), airports.get(2)),
                new FlightRoute(6, airports.get(5), airports.get(7))
        );

        @BeforeEach
        void initializeSchedule() throws ParseException {
            int i = 1;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Aircraft aircraft = AircraftFactory.create("H1");
            for (FlightRoute flightRoute : flightRoutes) {
                Date departure = TestUtil.addDays(format.parse("2020-01-01"), i);
                ScheduledFlight scheduledFlight = new ScheduledFlight(flightRoute, aircraft, departure);
                schedule.scheduleFlight(scheduledFlight);
                i++;
            }
        }

        @Test
        @DisplayName("then the schedule should contain the correct number of scheduled flights")
        void thenScheduleShouldContainOneElement() {
            assertEquals(6, schedule.getScheduledFlights().size());
        }

        @Nested
        @DisplayName("when a flight is removed")
        class AFlightRouteIsRemoved {

            @Test
            @DisplayName("then a flight should be removed")
            void thenAFlightShouldBeRemoved() {
                schedule.removeFlight(flightRoutes.get(0));
                assertEquals(5, schedule.getScheduledFlights().size());
            }

            @Test
            @DisplayName("then the flight should not be scheduled anymore")
            void thenTheCorrectFlightShouldBeRemoved() {
                FlightRoute flightRoute = flightRoutes.get(3);
                schedule.removeFlight(flightRoute);
                assertTrue(schedule.getScheduledFlights().stream().anyMatch(o -> o.getFlightRoute().getNumber() == flightRoutes.get(0).getNumber()));
                assertTrue(schedule.getScheduledFlights().stream().anyMatch(o -> o.getFlightRoute().getNumber() == flightRoutes.get(1).getNumber()));
                assertTrue(schedule.getScheduledFlights().stream().anyMatch(o -> o.getFlightRoute().getNumber() == flightRoutes.get(2).getNumber()));
                assertTrue(schedule.getScheduledFlights().stream().anyMatch(o -> o.getFlightRoute().getNumber() == flightRoutes.get(4).getNumber()));
                assertFalse(schedule.getScheduledFlights().stream().anyMatch(o -> o.getFlightRoute().getNumber() == flightRoutes.get(3).getNumber()));
            }
        }

        @Nested
        @DisplayName("when a flight is scheduled")
        class AFlightRouteIsScheduled {

            @Test
            @DisplayName("then the schedule should contain the added flight")
            void thenTheScheduleShouldContainTheAddedFlight() throws ParseException {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date departure = TestUtil.addDays(format.parse("2020-01-01"), 20);
                Aircraft aircraft = AircraftFactory.create("H1");
                ScheduledFlight scheduledFlight = new ScheduledFlight(flightRoutes.get(3), aircraft, departure);
                schedule.scheduleFlight(scheduledFlight);
                assertEquals(flightRoutes.get(3).getNumber(), schedule.getScheduledFlights().get(schedule.getScheduledFlights().size() - 1).getFlightRoute().getNumber());
                assertEquals(flightRoutes.get(3).getArrival(), schedule.getScheduledFlights().get(schedule.getScheduledFlights().size() - 1).getFlightRoute().getArrival());
                assertEquals(flightRoutes.get(3).getDeparture(), schedule.getScheduledFlights().get(schedule.getScheduledFlights().size() - 1).getFlightRoute().getDeparture());
                assertEquals(departure, schedule.getScheduledFlights().get(schedule.getScheduledFlights().size() - 1).getDepartureTime());
            }
        }

        @Nested
        @DisplayName("when a flight is searched")
        class AFlightRouteIsSearched {

            @Test
            @DisplayName("and the flight is scheduled then the flight should be returned")
            void thenTheFlightShouldBeReturned() throws ParseException {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date departure = TestUtil.addDays(format.parse("2020-01-01"), 2);
                assertEquals(flightRoutes.get(1).getNumber(), schedule.searchScheduledFlight(flightRoutes.get(1).getNumber()).getFlightRoute().getNumber());
                assertEquals(flightRoutes.get(1).getArrival(), schedule.searchScheduledFlight(flightRoutes.get(1).getNumber()).getFlightRoute().getArrival());
                assertEquals(flightRoutes.get(1).getDeparture(), schedule.searchScheduledFlight(flightRoutes.get(1).getNumber()).getFlightRoute().getDeparture());
                assertEquals(departure, schedule.searchScheduledFlight(flightRoutes.get(1).getNumber()).getDepartureTime());
            }

            @Test
            @DisplayName("and the flight is not scheduled then null should be returned")
            void thenNullShouldBeReturned() {
                schedule.removeFlight(flightRoutes.get(0));
                assertEquals(null, schedule.searchScheduledFlight(flightRoutes.get(0).getNumber()));
            }
        }
    }
}
