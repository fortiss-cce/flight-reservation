package flight.reservation.plane;

public class Aircraft {

    private final String model;
    private final int passengerCapacity;
    public int crewCapacity;

    public Aircraft (String model, int passengerCapacity, int crewCapacity)
    {
        this.model = model;
        this.passengerCapacity = passengerCapacity;
        this.crewCapacity = crewCapacity;

    }

    public String getModel() {
        return model;
    }
    public int getPassengerCapacity() {
        return passengerCapacity;
    }
    public int getCrewCapacity() {
        return crewCapacity;
    }

    //values are set once - therefore no setters needed
}
