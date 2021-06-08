package flight.reservation.plane;

public class Helicopter extends Aircraft {

    static private int getPassengerCapacity(String model) {
        if (model.equals("H1")) {
            return 4;
        } else if (model.equals("H2")) {
            return 6;
        } else {
            throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }
    public Helicopter(String model) {
        super(model, getPassengerCapacity(model));
    }

}
