package flight.reservation.plane;

public class PassengerPlane extends Aircraft {

    private int crewCapacity;

    public enum PlaneModel {
        A350("A350", 320, 40),
        A380("A380", 500, 42),
        ANTONOV_AN2("Antonov AN2", 15, 3),
        EMBRAER_190("Embraer 190", 25, 5);

        private String displayName;
        private int passengetCapacity;
        private int crewCapacity;


        PlaneModel(String displayName, int passengerCapacity, int crewCapacity) {
            this.displayName = displayName;
            this.passengetCapacity = passengerCapacity;
            this.crewCapacity = crewCapacity;
        }

        int getPassengerCapacity() {
            return passengetCapacity;
        }

        int getCrewCapacity() {
            return crewCapacity;
        }

        public static PlaneModel getEnum(String modelName) {
            String sanitizedString = modelName.toUpperCase().replaceAll("\\s", "_");
            return PlaneModel.valueOf(sanitizedString);
        }

        @Override public String toString() { return displayName; }
    }

    public PassengerPlane(PlaneModel model) {
        super(model.displayName, model.getPassengerCapacity());
        this.crewCapacity = model.getCrewCapacity();
    }

    public PassengerPlane(String model) {
        this(PlaneModel.getEnum(model));
    }

    public int getCrewCapacity() {
        return crewCapacity;
    }

}