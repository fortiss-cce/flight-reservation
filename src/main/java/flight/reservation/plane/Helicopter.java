package flight.reservation.plane;

public class Helicopter {


    public Helicopter extends Aircraft (String model) {
        super();
        final int passengerCapacity;
        if (model.equals("H1")) {
            passengerCapacity = 4;
        } else if (model.equals("H2")) {
            passengerCapacity = 6;
        } else {
            throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
        super(2, 4, model);
    }


}
