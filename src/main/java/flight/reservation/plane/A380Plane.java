package flight.reservation.plane;

public class A380Plane implements IAircraft {

    @Override
    public String getModel() {
        return "A380";
    }

    @Override
    public int getPassengerCapacity() {
        return 500;
    }

    @Override
    public int getCrewCapacity() {
        return 42;
    }
}
