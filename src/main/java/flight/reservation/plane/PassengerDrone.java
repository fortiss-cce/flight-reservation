package flight.reservation.plane;

public class PassengerDrone extends Aircraft {

    public PassengerDrone(String model) {
        super(model, 0);
        if (model.equals("HypaHype")) {
        } else {
            throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }
}
