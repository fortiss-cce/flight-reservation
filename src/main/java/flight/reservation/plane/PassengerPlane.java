package flight.reservation.plane;

import java.util.Map;


public class PassengerPlane extends Aircraft {
    static private final Map<String, int> capacityMap;

    private class PlaneSpecs(String model) {

        public int passengerCapacity;
        public int crewCapacity;

        public PlaneSpecs(String model) {
            switch (model) {
                case "A380":
                    passengerCapacity = 500;
                    crewCapacity = 42;
                    break;
                case "A350":
                    passengerCapacity = 320;
                    crewCapacity = 40;
                    break;
                case "Embraer 190":
                    passengerCapacity = 25;
                    crewCapacity = 5;
                    break;
                case "Antonov AN2":
                    passengerCapacity = 15;
                    crewCapacity = 3;
                    break;
                default:
                    throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
            }

        }
    }
    static PassengerPlane()
    {
        capacityMap = new Map<String, int>();
        capacityMap.put("A380", 500);
    }


    public PassengerPlane(String model) {
        super((new PlaneSpecs(model)).crewCapacity, (new PlaneSpecs(model)).passengerCapacity, model);
    }
}
