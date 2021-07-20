package flight.reservation.plane;

public class PassengerDrone extends AirCraft{

    public PassengerDrone(String model) {
        if (model.equals("HypaHype")) {
            this.model = model;
        } else {
            throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
        this.crewCapacity = 0;
        this.passengerCapacity = 0;
    }
}
