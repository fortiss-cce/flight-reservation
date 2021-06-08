package flight.reservation.plane;

public class PassengerPlane extends Aircraft {

    public PassengerPlane(String model) {
        setModel(model);
        switch (model) {
            case "A380":
                setPassengerCapacity(500);
                setCrewCapacity(42);
                break;
            case "A350":
                setPassengerCapacity(320);
                setCrewCapacity(40);
                break;
            case "Embraer 190":
                setPassengerCapacity(25);
                setCrewCapacity(5);
                break;
            case "Antonov AN2":
                setPassengerCapacity(15);
                setCrewCapacity(3);
                break;
            default:
                throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }

}
