package flight.reservation.plane;

public class HypaHypePassengerDrone implements IAircraft {

    @Override
    public String getModel() {
        return "HypyHype";
    }


    @Override
    public int getPassengerCapacity() {
        return 4;
    }

    @Override
    public int getCrewCapacity() {
        return 0;
    }
}
