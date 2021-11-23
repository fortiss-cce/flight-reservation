package flight.reservation.plane;

public class Embraer190Plane implements IAircraft {

    @Override
    public String getModel() {
        return "Embraer 190";
    }

    @Override
    public int getPassengerCapacity() {
        return 25;
    }

    @Override
    public int getCrewCapacity() {
        return 5;
    }
}
