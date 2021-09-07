package flight.reservation;

import flight.reservation.flight.FlightRoute;
import flight.reservation.flight.Schedule;
import flight.reservation.flight.ScheduledFlight;
import flight.reservation.order.FlightOrder;
import flight.reservation.payment.CreditCard;
import flight.reservation.plane.Aircraft;
import flight.reservation.plane.AircraftFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Scenario Tests")
public class ScenarioTest {


    private Schedule schedule;
    private Customer customer;
    private Airport startAirport;
    private Airport destinationAirport;
    private FlightRoute flightRoute;

    @BeforeEach
    public void initSchedule() {
        schedule = new Schedule();
        schedule.clear();
    }

    @Nested
    @DisplayName("Scenario 1: A customer books 2 passengers on a scheduled flight from John F. Kennedy International Airport to Berlin (flight 5) on a helicopter and pays it with pay pal")
    class CustomerTwoPassengersPaypalPayment {

        @BeforeEach
        public void init() {
            customer = new Customer("Max Mustermann", "amanda@ya.com");
        }

        @Nested
        @DisplayName("and the flight is theoretically possible")
        class FlightRouteIsPossible {

            @BeforeEach
            public void initFlights() {
                startAirport = new Airport("JFK");
                destinationAirport = new Airport("FRA");
                Aircraft aircraft = AircraftFactory.create("H1");
                flightRoute = new FlightRoute(1, startAirport, destinationAirport);
                Date departure = TestUtil.addDays(Date.from(Instant.now()), 3);
                ScheduledFlight scheduledFlight = new ScheduledFlight(flightRoute, aircraft, departure);
                schedule.scheduleFlight(scheduledFlight);
            }


            @Nested
            @DisplayName("and the H1 is fully booked")
            class H1FullyBooked {

                @BeforeEach
                public void initPassengers() {
                    ScheduledFlight scheduledFlight = schedule.searchScheduledFlight(flightRoute.getNumber());
                    Passenger[] passengers = new Passenger[3];
                    for (int i = 0; i < passengers.length; i++) {
                        passengers[i] = new Passenger("P" + i);
                    }
                    scheduledFlight.addPassengers(Arrays.asList(passengers));
                }

                @Test
                @DisplayName("then the booking should be stopped and the payment should not proceed and the capacity should be unchanged")
                void thenTheBookingShouldBeStopped() throws NoSuchFieldException {
                    ScheduledFlight scheduledFlight = schedule.searchScheduledFlight(flightRoute.getNumber());
                    assertThrows(IllegalStateException.class, () -> customer.createOrder(Arrays.asList("Amanda", "Max"), Arrays.asList(scheduledFlight), 180));
                    assertEquals(3, scheduledFlight.getPassengers().size());
                    assertEquals(4, scheduledFlight.getCapacity());
                    assertEquals(1, scheduledFlight.getAvailableCapacity());
                    assertTrue(scheduledFlight.getPassengers().stream().noneMatch(passenger -> passenger.getName().equals("Max")));
                    assertTrue(scheduledFlight.getPassengers().stream().noneMatch(passenger -> passenger.getName().equals("Amanda")));
                }
            }

            @Nested
            @DisplayName("and the H1 is empty")
            class H1Empty {
                @Test
                @DisplayName("then the booking should succeed")
                void thenTheBookingShouldSucceed() throws NoSuchFieldException {
                    ScheduledFlight scheduledFlight = schedule.searchScheduledFlight(flightRoute.getNumber());
                    FlightOrder order = customer.createOrder(Arrays.asList("Amanda", "Max"), Arrays.asList(scheduledFlight), 180);

                    assertEquals(2, scheduledFlight.getPassengers().size());
                    assertEquals(4, scheduledFlight.getCapacity());
                    assertEquals(2, scheduledFlight.getAvailableCapacity());
                    assertTrue(scheduledFlight.getPassengers().stream().anyMatch(passenger -> passenger.getName().equals("Max")));
                    assertTrue(scheduledFlight.getPassengers().stream().anyMatch(passenger -> passenger.getName().equals("Amanda")));
                    assertFalse(order.isClosed());
                    assertEquals(order, customer.getOrders().get(0));

                    boolean isProcessed = order.processOrderWithPayPal(customer.getEmail(), "amanda1985");
                    assertTrue(isProcessed);
                    assertTrue(order.isClosed());
                }
            }
        }
    }

    @Nested
    @DisplayName("Scenario 2: A customer books 1 passenger on a a scheduled flight from Berlin to Frankfurt (flight 0) and pays it with credit card")
    class CustomerOnePassengerCreditCardPayment {
        private CreditCard creditCard;

        @BeforeEach
        public void init() {
            // flights
            startAirport = new Airport("BER");
            destinationAirport = new Airport("FRA");
            Aircraft aircraft = AircraftFactory.create("A380");
            flightRoute = new FlightRoute(1, startAirport, destinationAirport);
            Date departure = TestUtil.addDays(Date.from(Instant.now()), 3);
            ScheduledFlight scheduledFlight = new ScheduledFlight(flightRoute, aircraft, departure);
            schedule.scheduleFlight(scheduledFlight);
            // customer
            customer = new Customer("Max Mustermann", "amanda@ya.com");
            creditCard = Mockito.mock(CreditCard.class, Mockito.CALLS_REAL_METHODS);
        }

        @Nested
        @DisplayName("and credit card limit is reached")
        class CreditCardLimitReached {

            @BeforeEach
            public void initCreditCard() {
                Mockito.when(creditCard.isValid()).thenReturn(true);
                Mockito.when(creditCard.getAmount()).thenReturn(10.0);
            }

            @Test
            @DisplayName("then the payment should not succeed and the booking should not be closed/payed")
            void thenThePaymentAndBookingShouldNotSucceed() {
                ScheduledFlight scheduledFlight = schedule.searchScheduledFlight(flightRoute.getNumber());
                FlightOrder order = customer.createOrder(Arrays.asList("Max"), Arrays.asList(scheduledFlight), 100);
                assertThrows(IllegalStateException.class, () -> order.processOrderWithCreditCard(creditCard));
                assertFalse(order.isClosed());
            }
        }

        @Nested
        @DisplayName("and credit card is not valid")
        class CreditCardNotValid {

            @BeforeEach
            public void initCreditCard() {
                Mockito.when(creditCard.isValid()).thenReturn(false);
            }

            @Test
            @DisplayName("then the booking should not be closed/payed")
            void thenTheBookingShouldNotSucceed() {
                ScheduledFlight scheduledFlight = schedule.searchScheduledFlight(flightRoute.getNumber());
                FlightOrder order = customer.createOrder(Arrays.asList("Max"), Arrays.asList(scheduledFlight), 100);
                assertThrows(IllegalStateException.class, () -> order.processOrderWithCreditCard(creditCard));
                assertFalse(order.isClosed());
            }
        }

        @Nested
        @DisplayName("and credit card is valid")
        class CreditCardValid {

            @BeforeEach
            public void initCreditCard() {
                Mockito.when(creditCard.isValid()).thenReturn(true);
                creditCard.setAmount(1000.0);
            }

            @Test
            @DisplayName("then the booking should succeed")
            void thenTheBookingShouldSucceed() throws NoSuchFieldException {
                ScheduledFlight scheduledFlight = schedule.searchScheduledFlight(flightRoute.getNumber());
                FlightOrder order = customer.createOrder(Arrays.asList("Max"), Arrays.asList(scheduledFlight), 100);
                boolean processed = order.processOrderWithCreditCard(creditCard);
                assertTrue(processed);
                assertTrue(order.isClosed());
                assertEquals(order, customer.getOrders().get(0));
                assertEquals(900, creditCard.getAmount());
                assertEquals(1, scheduledFlight.getPassengers().size());
                assertEquals("Max", scheduledFlight.getPassengers().get(0).getName());
                assertEquals(500, scheduledFlight.getCapacity());
                assertEquals(499, scheduledFlight.getAvailableCapacity());
            }
        }
    }


}
