package flight.reservation.plane;

import flight.reservation.plane.Aircraft;

public class PassengerPlane implements Aircraft {

    private final String model;
    private final int passengerCapacity;
    private final int crewCapacity;

    public PassengerPlane(String model) {
        this.model = model;
        switch (model) {
        case "A380":
            this.passengerCapacity = 500;
            this.crewCapacity = 42;
            break;
        case "A350":
            this.passengerCapacity = 320;
            this.crewCapacity = 40;
            break;
        case "Embraer 190":
            this.passengerCapacity = 25;
            this.crewCapacity = 5;
            break;
        case "Antonov AN2":
            this.passengerCapacity = 15;
            this.crewCapacity = 3;
            break;
        default:
            throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getPassengerCapacity() {
        return this.passengerCapacity;
    }

    @Override
    public int getCrewCapacity() {
        return this.crewCapacity;
    }
}
