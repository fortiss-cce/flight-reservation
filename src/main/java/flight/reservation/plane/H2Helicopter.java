package flight.reservation.plane;

public class H2Helicopter extends Helicopter {

    @Override
    public String getModel() {
        return "H2";
    }

    @Override
    public int getPassengerCapacity() {
        return 6;
    }
}
