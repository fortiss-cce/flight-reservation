package flight.reservation.plane;

public class PassengerDrone extends Aircraft {

    private static int PASSENGER_CAPACITY = 4;
    private static int CREW_CAPACITY = 0;

    public PassengerDrone(String model) {
        super(model, PASSENGER_CAPACITY, CREW_CAPACITY);
        if (model.equals("HypaHype")) {
        } else {
            throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }
}
