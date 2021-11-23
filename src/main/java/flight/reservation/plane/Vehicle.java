package flight.reservation.plane;

public class Vehicle {
    protected String model;
    protected int crewCapacity = 0;
    protected int passengerCapacity = 0;

    public String getModel() {
        return model;
    }

    public int getCrewCapacity() {
        return crewCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }
}
