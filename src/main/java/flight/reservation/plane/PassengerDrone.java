package flight.reservation.plane;

public class PassengerDrone extends Aircraft {

    public PassengerDrone(String model) {
        super(model);
        if (model.equals("HypaHype")) {
            this.setModel(model);
        } else {
            throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }
}
