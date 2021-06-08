package flight.reservation.plane;

public class Helicopter extends Aircraft {
    private static final int H1_PASSENGER_CAPACITY = 4;
    private static final int H2_PASSENGER_CAPACITY = 6;
    private static final int CREW_PASSENGER_CAPACITY = 2;
    private static final String H1_MODEL_IDENTIFIER = "H1";
    private static final String H2_MODEL_IDENTIFIER = "H2";

    private Helicopter() {
    }

    public Helicopter(String model) {
        // We don't want to break the existing API (public constructor) here
        // What would be a reasonable way to implement the factory method pattern then?
        // Does it make sense at all?
        Helicopter helicopter;
        if (model.equals(H1_MODEL_IDENTIFIER)) {
            helicopter = createH1Helicopter();
        } else if (model.equals(H2_MODEL_IDENTIFIER)) {
            helicopter = createH2Helicopter();
        } else {
            throw new IllegalArgumentException(String.format(MODEL_TYPE_EXCEPTION_MESSAGE_FORMAT, model));
        }
        setModel(helicopter.getModel());
        setPassengerCapacity(helicopter.getPassengerCapacity());
        setCrewCapacity(helicopter.getCrewCapacity());
    }

    public static Helicopter createH1Helicopter() {
        Helicopter helicopter = new Helicopter();
        helicopter.setModel(H1_MODEL_IDENTIFIER);
        helicopter.setPassengerCapacity(H1_PASSENGER_CAPACITY);
        helicopter.setCrewCapacity(CREW_PASSENGER_CAPACITY);
        return helicopter;
    }

    public static Helicopter createH2Helicopter() {
        Helicopter helicopter = new Helicopter();
        helicopter.setModel(H2_MODEL_IDENTIFIER);
        helicopter.setPassengerCapacity(H2_PASSENGER_CAPACITY);
        helicopter.setCrewCapacity(CREW_PASSENGER_CAPACITY);
        return helicopter;
    }
}
