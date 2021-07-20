package flight.reservation.plane;

public class Helicopter extends AAircraft {
    public Helicopter(String model) {
        super(model);
        crewCapacity = 2;
        if (model.equals("H1")) {
            passengerCapacity = 4;
        } else if (model.equals("H2")) {
            passengerCapacity = 6;
        } else {
            throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }
}
