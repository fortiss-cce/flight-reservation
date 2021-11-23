package flight.reservation.plane;

public class PassengerDrone extends Aircraft {

    static final String MODEL_HYPA_HYPE = "HypaHype";

    public PassengerDrone(String model) {
        super();

        this.model = model;
        this.passengerCapacity = 4;
        switch (model)  {
            case MODEL_HYPA_HYPE:
            default:
                throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }
}
