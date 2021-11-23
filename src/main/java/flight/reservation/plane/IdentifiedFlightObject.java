package flight.reservation.plane;

public abstract class IdentifiedFlightObject {
    String model;
    int passengerCapacity;
    int crewCapacity;

    public String getModel() {
        return model;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public int getCrewCapacity() {
        return crewCapacity;
    }
}
