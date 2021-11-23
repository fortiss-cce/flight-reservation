package flight.reservation.plane;

public class H1Helicopter extends Helicopter {

    @Override
    public String getModel() {
        return "H1";
    }

    @Override
    public int getPassengerCapacity() {
        return 4;
    }
}
