package flight.reservation.plane;

public class PassengerDrone extends Aircraft {

    public static final String MODEL_HYPA_HYPE = "HypaHype";

    public PassengerDrone(String model) {
        super(model);

        this.passengerCapacity = 4;
        this.crewCapacity = 0;
        switch (model)  {
            case MODEL_HYPA_HYPE:
                break;
            default:
                throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }
}
