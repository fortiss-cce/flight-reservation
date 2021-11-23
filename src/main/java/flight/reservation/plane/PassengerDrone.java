package flight.reservation.plane;

public class PassengerDrone extends Vehicle {
    public PassengerDrone(String model) {
        if (model.equals("HypaHype")) {
            this.model = model;
            this.passengerCapacity = 4;
        } else {
            throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }
}
