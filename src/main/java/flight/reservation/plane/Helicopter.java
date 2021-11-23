package flight.reservation.plane;

public class Helicopter extends Aircraft {

    public static final String MODEL_H1 = "H1";
    public static final String MODEL_H2 = "H2";

    public Helicopter(String model) {
        super(model);

        crewCapacity = 2;
        switch(model) {
            case MODEL_H1:
                passengerCapacity = 4;
                break;
            case MODEL_H2:
                passengerCapacity = 6;
                break;
            default:
                throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }
}
