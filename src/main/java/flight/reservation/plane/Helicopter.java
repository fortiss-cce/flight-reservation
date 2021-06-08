package flight.reservation.plane;

public class Helicopter extends Aircraft {
    private static final int CREW_CAPACITY = 2;

    public enum HeliModel {
        H1(4),
        H2(6);

        private int passengerCapacity;


        HeliModel(int passengerCapacity) {
            this.passengerCapacity = passengerCapacity;
        }

        int getPassengerCapacity() {
            return passengerCapacity;
        }
    }

    public Helicopter(String model) {
        this(HeliModel.valueOf(model));
    }

    public Helicopter(HeliModel model) {
        super(model.toString(), model.getPassengerCapacity(), CREW_CAPACITY);
    }

}
