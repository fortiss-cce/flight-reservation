package flight.reservation.plane;

public class PassengerPlane extends Aircraft {

    static final String MODEL_A380 = "A380";
    static final String MODEL_A350 = "A350";
    static final String MODEL_EMBRAER_190 = "Embraer 190";
    static final String MODEL_ANTONOV_AN2 = "Antonov AN2";

    public PassengerPlane(String model) {
        super();

        this.model = model;
        switch (model) {
            case MODEL_A380:
                passengerCapacity = 500;
                crewCapacity = 42;
                break;
            case MODEL_A350:
                passengerCapacity = 320;
                crewCapacity = 40;
                break;
            case MODEL_EMBRAER_190:
                passengerCapacity = 25;
                crewCapacity = 5;
                break;
            case MODEL_ANTONOV_AN2:
                passengerCapacity = 15;
                crewCapacity = 3;
                break;
            default:
                throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }

}
