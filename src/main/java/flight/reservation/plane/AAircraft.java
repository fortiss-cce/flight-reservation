package flight.reservation.plane;

public abstract class AAircraft {
    protected int crewCapacity = 0;
    protected int passengerCapacity = 0;
    private final String model;

    protected AAircraft(String model) {
        this.model = model;
    }

    public int getCrewCapacity() {
        return crewCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public String getModel() {
        return model;
    }
}
