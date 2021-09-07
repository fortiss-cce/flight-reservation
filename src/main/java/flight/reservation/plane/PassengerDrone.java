package flight.reservation.plane;

public class PassengerDrone extends AbstractPlane {
    public PassengerDrone(String model) {
        this.crewCapacity = 0;
        this.passengerCapacity = 4;
        if (model.equals("HypaHype")) {
            this.model = model;
        } else {
            throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }
}
