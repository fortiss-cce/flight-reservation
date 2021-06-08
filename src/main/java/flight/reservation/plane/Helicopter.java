package flight.reservation.plane;

public class Helicopter extends Plane {

    public Helicopter(String model) {
        this.model = model;
        this.crewCapacity = 2;
        switch (model) {
            case "H1":
                this.passengerCapacity = 4;
                break;
            case "H2":
                this.passengerCapacity = 6;
                break;
            default: 
                throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }
}
