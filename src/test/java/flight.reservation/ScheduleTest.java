package flight.reservation;

import flight.reservation.flight.Connection;
import flight.reservation.flight.Schedule;
import flight.reservation.flight.ScheduledFlight;
import flight.reservation.plane.AircraftModel;
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
        @DisplayName("then removing a connection should still yield an empty list")
        void thenScheduleShouldYieldEmpty() {
            schedule.removeAllScheduledFlights(new Connection(1, new Airport("a", "a", "a"), new Airport("b", "b", "b"), AircraftModel.A380));
            assertEquals(0, schedule.getScheduledFlights().size());
        }

        @Nested
        @DisplayName("when a flight is scheduled")
        class WhenAFlightIsScheduled {

            private Connection connection;
            private Date departure;

            @BeforeEach
            void scheduleOneFlight() {
                Airport startAirport = new Airport("Berlin Airport", "BER", "Berlin, Berlin");
                Airport destAirport = new Airport("Frankfurt Airport", "FRA", "Frankfurt, Hesse");

                connection = new Connection(1, startAirport, destAirport, AircraftModel.A380);
                departure = TestUtil.addDays(Date.from(Instant.now()), 3);
                schedule.scheduleFlight(connection, departure);
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
                assertEquals(connection, scheduledFlight.getConnection());
                assertEquals(departure, scheduledFlight.getDepartureTime());
            }

            @Test
            @DisplayName("then the schedule should not be empty anymore")
            void thenSearchShouldReturnFlight() {
                ScheduledFlight scheduledFlight = schedule.getScheduledFlights().get(0);
                assertEquals(scheduledFlight, schedule.searchScheduledFlight(1));
            }

            @Test
            @DisplayName("then removing a connection should yield an empty list")
            void thenRemoveShouldYieldEmpty() {
                schedule.removeAllScheduledFlights(connection);
                assertEquals(0, schedule.getScheduledFlights().size());
            }
        }
    }

    @Nested
    @DisplayName("Given an existing Schedule")
    class GivenAnExistingSchedule {

        List<Airport> airports = Arrays.asList(
                new Airport("Berlin Airport", "BER", "Berlin, Berlin"),
                new Airport("Frankfurt Airport", "FRA", "Frankfurt, Hesse"),
                new Airport("Madrid Barajas Airport", "MAD", "Barajas, Madrid"),
                new Airport("Guarulhos International Airport", "GRU", "Guarulhos (São Paulo)"),
                new Airport("John F. Kennedy International Airport", "JFK", "Queens, New York, New York"),
                new Airport("Istanbul Airport", "IST", "Arnavutköy, Istanbul"),
                new Airport("Dubai International Airport", "DXB", "Garhoud, Dubai"),
                new Airport("Chengdu Shuangliu International Airport", "CTU", "Shuangliu-Wuhou, Chengdu, Sichuan")
        );

        List<Connection> connections = Arrays.asList(
                new Connection(1, airports.get(0), airports.get(1), AircraftModel.A350),
                new Connection(2, airports.get(1), airports.get(2), AircraftModel.A380),
                new Connection(3, airports.get(2), airports.get(4), AircraftModel.Embraer190),
                new Connection(4, airports.get(3), airports.get(2), AircraftModel.AntonovAN2),
                new Connection(5, airports.get(4), airports.get(2), AircraftModel.H1),
                new Connection(6, airports.get(5), airports.get(7), AircraftModel.HypaHype)
        );

        @BeforeEach
        void initializeSchedule() throws ParseException {
            int i = 1;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            for (Connection flight : connections) {
                Date departure = TestUtil.addDays(format.parse("2020-01-01"), i);
                schedule.scheduleFlight(flight, departure);
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
        class AFlightIsRemoved {

            @Test
            @DisplayName("then a flight should be removed")
            void thenAFlightShouldBeRemoved() {
                schedule.removeAllScheduledFlights(connections.get(0));
                assertEquals(5, schedule.getScheduledFlights().size());
            }

            @Test
            @DisplayName("then the flight should not be scheduled anymore")
            void thenTheCorrectFlightShouldBeRemoved() {
                Connection flight = connections.get(3);
                schedule.removeAllScheduledFlights(flight);
                assertTrue(schedule.getScheduledFlights().stream().anyMatch(o -> o.getConnection() == connections.get(0)));
                assertTrue(schedule.getScheduledFlights().stream().anyMatch(o -> o.getConnection() == connections.get(1)));
                assertTrue(schedule.getScheduledFlights().stream().anyMatch(o -> o.getConnection() == connections.get(2)));
                assertTrue(schedule.getScheduledFlights().stream().anyMatch(o -> o.getConnection() == connections.get(4)));
                assertFalse(schedule.getScheduledFlights().stream().anyMatch(o -> o.getConnection() == connections.get(3)));
            }
        }

        @Nested
        @DisplayName("when a flight is scheduled")
        class AFlightIsScheduled {

            @Test
            @DisplayName("then the schedule should contain the added flight")
            void thenTheScheduleShouldContainTheAddedFlight() throws ParseException {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date departure = TestUtil.addDays(format.parse("2020-01-01"), 20);
                schedule.scheduleFlight(connections.get(3), departure);
                assertEquals(connections.get(3), schedule.getScheduledFlights().get(schedule.getScheduledFlights().size() - 1).getConnection());
                assertEquals(departure, schedule.getScheduledFlights().get(schedule.getScheduledFlights().size() - 1).getDepartureTime());
            }
        }

        @Nested
        @DisplayName("when a flight is searched")
        class AFlightIsSearched {

            @Test
            @DisplayName("and the flight is scheduled then the flight should be returned")
            void thenTheFlightShouldBeReturned() throws ParseException {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date departure = TestUtil.addDays(format.parse("2020-01-01"), 2);
                assertEquals(connections.get(1), schedule.searchScheduledFlight(connections.get(1).getNumber()).getConnection());
                assertEquals(departure, schedule.searchScheduledFlight(connections.get(1).getNumber()).getDepartureTime());
            }

            @Test
            @DisplayName("and the flight is not scheduled then null should be returned")
            void thenNullShouldBeReturned() {
                schedule.removeAllScheduledFlights(connections.get(0));
                assertEquals(null, schedule.searchScheduledFlight(connections.get(0).getNumber()));
            }
        }
    }
}
