package flight.reservation.plane;

public class Plane {
    protected String model;
    protected int passengerCapacity;
    protected int crewCapacity;

    public String getModel(){
        return this.model;
    }

    public int getPassengerCapacity(){
        return this.passengerCapacity;
    }

    public int getCrewCapacity(){
        return this.crewCapacity;
    }
}
