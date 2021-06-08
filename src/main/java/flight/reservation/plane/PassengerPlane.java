package flight.reservation.plane;

public class PassengerPlane extends Aircraft {

    public int crewCapacity;

    private static int getPassengerCapacity(String model) {
        switch (model) {
            case "A380":
                return 500;
            case "A350":
                return 320;
            case "Embraer 190":
                return 25;
            case "Antonov AN2":
                return 15;
            default:
                throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }

    public PassengerPlane(String model) {
        super(model, getPassengerCapacity(model));
        switch (model) {
            case "A380":
                crewCapacity = 42;
                break;
            case "A350":
                crewCapacity = 40;
                break;
            case "Embraer 190":
                crewCapacity = 5;
                break;
            case "Antonov AN2":
                crewCapacity = 3;
                break;
            default:
                throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }

}
