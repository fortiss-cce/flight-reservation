package flight.reservation.plane;

public class PassengerDrone extends AAircraft {
    public PassengerDrone(String model) {
        super(model);
        passengerCapacity = 4;
        if (!model.equals("HypaHype")) {
            throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }
}
