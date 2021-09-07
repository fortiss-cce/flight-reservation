package flight.reservation.plane;

public abstract class AbstractPlane {
    protected String model;
    protected int passengerCapacity;
    protected int crewCapacity;

    public int getCrewCapacity() {return crewCapacity;}
    public String getModel() {return model;}
    public int getPassengerCapacity() {return passengerCapacity;}
}
