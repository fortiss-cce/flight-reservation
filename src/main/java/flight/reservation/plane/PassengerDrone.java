package flight.reservation.plane;

// TODO: Common base class?
public class PassengerDrone {
    private final String model;

    public PassengerDrone(String model) {
        if (model.equals("HypaHype")) {
            this.model = model;
        } else {
            throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }
}
