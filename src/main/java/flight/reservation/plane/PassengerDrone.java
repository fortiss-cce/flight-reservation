package flight.reservation.plane;

public class PassengerDrone extends Plane{

    public PassengerDrone(String model) {
        this.passengerCapacity = 4;
        this.crewCapacity = 0;
        if (model.equals("HypaHype")) {
            this.model = model;
        } else {
            throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }
}
