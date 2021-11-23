package flight.reservation.plane;

public abstract class Helicopter implements IAircraft {
    @Override
    public int getCrewCapacity() { return 2; }
}
