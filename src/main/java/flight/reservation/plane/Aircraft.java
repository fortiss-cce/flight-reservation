package flight.reservation.plane;

public class Aircraft {
    protected final String model;
    protected final int passengerCapacity;

    public Aircraft(String model, int passengerCapacity) {
        this.model = model;
        this.passengerCapacity = passengerCapacity;
    }

    public String getModel() {
        return model;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }
}
