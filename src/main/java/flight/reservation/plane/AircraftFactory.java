package flight.reservation.plane;

public class AircraftFactory {

    public static Aircraft createInstance(AircraftModelType type) {
        Aircraft aircraft;
        switch (type) {
            case A380:
                aircraft = new PassengerPlane("A380", 500, 42);
                break;
            case A350:
                aircraft = new PassengerPlane("A350", 320, 40);
                break;
            case Embraer190:
                aircraft = new PassengerPlane("Embraer 190", 25, 5);
                break;
            case AntonovAN2:
                aircraft = new PassengerPlane("Antonov AN2", 15, 3);
                break;
            case H1:
                aircraft = new Helicopter("H1", 4, 0);
                break;
            case H2:
                aircraft = new Helicopter("H2", 6, 0);
                break;
            case HypaHype:
                aircraft = new PassengerDrone("HypaHype", 0, 2);
                break;
            default:
                throw new IllegalArgumentException(String.format(
                        "Model type '%s' is not recognized", type));
        }
        return aircraft;

    }

}
