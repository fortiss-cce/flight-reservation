package flight.reservation.plane;

public abstract class Aircraft {
    protected final String MODEL_TYPE_EXCEPTION_MESSAGE_FORMAT = "Model type '%s' is not recognized";

    private String model;
    private int passengerCapacity;
    private int crewCapacity;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getCrewCapacity() {
        return crewCapacity;
    }

    public void setCrewCapacity(int crewCapacity) {
        this.crewCapacity = crewCapacity;
    }
}
