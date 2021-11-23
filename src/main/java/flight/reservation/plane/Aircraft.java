package flight.reservation.plane;

public class Aircraft {

    private final int crewCapacity;
    private final int passengerCapacity;
    private final String model;

    public Aircraft(int crewCapacity, int passengerCapacity, String model) {
        this.crewCapacity = crewCapacity;
        this.passengerCapacity = passengerCapacity;
        this.model = model;
    }
    public int getCrewCapacity() { return this.crewCapacity; }

    public int getPassengerCapacity() { return this.passengerCapacity; }

    public String getModel() { return this.model; }

}


