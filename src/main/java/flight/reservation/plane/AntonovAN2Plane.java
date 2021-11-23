package flight.reservation.plane;

public class AntonovAN2Plane implements IAircraft {

    @Override
    public String getModel() {
        return "Antonov AN2";
    }

    @Override
    public int getPassengerCapacity() {
        return 15;
    }

    @Override
    public int getCrewCapacity() {
        return 3;
    }
}
