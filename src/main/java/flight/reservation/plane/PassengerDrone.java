package flight.reservation.plane;

public class PassengerDrone extends Plane {

    public PassengerDrone(String model) {
        super(model);
        checkModel(model);
    }

    public void checkModel(String model) {
        if (model.equals("HypaHype")) {
            setPassengerCapacity(4);
            setCrewCapacity(0);
        } else {
            throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }

    }
}
