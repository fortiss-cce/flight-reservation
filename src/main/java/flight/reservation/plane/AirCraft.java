package flight.reservation.plane;

public abstract class AirCraft {

    protected String model; //TODO: replace strings by enum
    protected int passengerCapacity;
    protected int crewCapacity;

    public String getModel() {
        return this.model;
    }

    public int getPassengerCapacity() {
        return this.passengerCapacity;
    }

    public int getCrewCapacity() {
        return this.crewCapacity;
    }
}
