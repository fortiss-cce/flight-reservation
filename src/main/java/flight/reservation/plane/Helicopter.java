package flight.reservation.plane;

public class Helicopter extends AirCraft {

    public Helicopter(String model) {
        this.model = model;
        if (model.equals("H1")) {
            this.passengerCapacity = 4;
        } else if (model.equals("H2")) {
            this.passengerCapacity = 6;
        } else {
            throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
        this.crewCapacity = 0;

    }


}
