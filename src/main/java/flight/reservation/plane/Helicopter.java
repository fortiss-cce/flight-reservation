package flight.reservation.plane;

public class Helicopter extends Plane {

    public Helicopter(String model) {
        super(model);
        checkModel(model);
    }

    public void checkModel(String model) {
        if (model.equals("H1")) {
            setPassengerCapacity(4);
            setCrewCapacity(2);
        } else if (model.equals("H2")) {
            setPassengerCapacity(6);
            setCrewCapacity(2);
        } else {
            throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }
}
