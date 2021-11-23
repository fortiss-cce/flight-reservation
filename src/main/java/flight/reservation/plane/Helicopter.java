package flight.reservation.plane;

public class Helicopter extends Aircraft {

    static final String MODEL_H1 = "H1";
    static final String MODEL_H2 = "H2";

    public Helicopter(String model) {
        super();

        this.model = model;
        switch(model) {
            case MODEL_H1:
                passengerCapacity = 4;
                break;
            case MODEL_H2:
                passengerCapacity = 6;
                break;
            default:
                throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }
}
