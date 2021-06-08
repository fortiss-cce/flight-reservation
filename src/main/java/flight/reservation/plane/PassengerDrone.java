package flight.reservation.plane;

public class PassengerDrone {

    public PassengerDrone(String model) {
        if (model.equals("HypaHype")) {
        } else {
            throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }
}
