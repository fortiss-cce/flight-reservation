package flight.reservation.plane;

public enum AircraftModel {
    A380(AircraftType.PassengerPlane, "Airbus A380", 42, 500),
    A350(AircraftType.PassengerPlane, "Airbus A350", 40, 320),
    Embraer190(AircraftType.PassengerPlane, "Embraer 190", 5, 25),
    AntonovAN2(AircraftType.PassengerPlane, "Antonov AN2", 3, 15),
    H1(AircraftType.Helicopter, "H1", 2, 4),
    H2(AircraftType.Helicopter, "H2", 2, 6),
    HypaHype(AircraftType.PassengerDrone, "HypaHype", 0, 4);

    private final AircraftType aircraftType;
    private final String modelName;
    private final int maxCrewCapacity;
    private final int maxPassengerCapacity;

    AircraftModel(AircraftType aircraftType, String modelName, int maxCrewCapacity, int maxPassengerCapacity) {
        this.aircraftType = aircraftType;
        this.modelName = modelName;
        this.maxCrewCapacity = maxCrewCapacity;
        this.maxPassengerCapacity = maxPassengerCapacity;
    }

    public AircraftType getAircraftType() {
        return aircraftType;
    }

    public String getModelName() {
        return modelName;
    }

    public int getMaxCrewCapacity() {
        return maxCrewCapacity;
    }

    public int getMaxPassengerCapacity() {
        return maxPassengerCapacity;
    }
}
