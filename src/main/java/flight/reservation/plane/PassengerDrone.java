package flight.reservation.plane;

public class PassengerDrone extends Aircraft {
    private final int PASSENGER_CAPACITY = 4;
    private final int CREW_CAPACITY = 0;
    private final String VALID_PASSENGER_DRONE_MODEL = "HypaHype";

    public PassengerDrone(String model) {
        setPassengerCapacity(PASSENGER_CAPACITY);
        setCrewCapacity(CREW_CAPACITY);
        if (model.equals(VALID_PASSENGER_DRONE_MODEL)) {
            setModel(model);
        } else {
            throw new IllegalArgumentException(String.format(MODEL_TYPE_EXCEPTION_MESSAGE_FORMAT, model));
        }
    }
}
