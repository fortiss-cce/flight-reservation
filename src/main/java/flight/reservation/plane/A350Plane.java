package flight.reservation.plane;

public class A350Plane implements IAircraft {

    @Override
    public String getModel() {
        return "A350";
    }

    @Override
    public int getPassengerCapacity() {
        return 320;
    }

    @Override
    public int getCrewCapacity() {
        return 40;
    }
}
