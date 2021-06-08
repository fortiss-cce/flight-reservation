package flight.reservation.plane;

public class Helicopter extends Aircraft {
    private final int H1_PASSENGER_CAPACITY = 4;
    private final int H2_PASSENGER_CAPACITY = 6;
    private final int CREW_PASSENGER_CAPACITY = 2;
    private final String H1_MODEL_IDENTIFIER = "H1";
    private final String H2_MODEL_IDENTIFIER = "H2";

    public Helicopter(String model) {
        setModel(model);
        setCrewCapacity(CREW_PASSENGER_CAPACITY);
        if (model.equals(H1_MODEL_IDENTIFIER)) {
            setPassengerCapacity(H1_PASSENGER_CAPACITY);
        } else if (model.equals(H2_MODEL_IDENTIFIER)) {
            setPassengerCapacity(H2_PASSENGER_CAPACITY);
        } else {
            throw new IllegalArgumentException(String.format(MODEL_TYPE_EXCEPTION_MESSAGE_FORMAT, model));
        }
    }
}
