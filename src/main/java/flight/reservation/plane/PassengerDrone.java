package flight.reservation.plane;

public class PassengerDrone extends AirCraft{

    public PassengerDrone(AirCraftModel airCraftModel) {
        if (airCraftModel == AirCraftModel.HypaHype) {
            this.model = "HypaHype";
        } else {
            throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", this.model));
        }
        this.crewCapacity = 0;
        this.passengerCapacity = 0;
    }
}
