package flight.reservation.plane;

import java.util.*;

public class PassengerPlane extends Aircraft {

    private int passengerCapacity;
    private int crewCapacity;
    private static final Map<String, List<Integer>> CAPACITY_MAP;

    static {
        CAPACITY_MAP = PassengerPlane.populateCapacityMap();
    }

    public PassengerPlane(String model) {
        super(model);
        this.initializeCapacity();
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getCrewCapacity() {
        return crewCapacity;
    }

    public void setCrewCapacity(int crewCapacity) {
        this.crewCapacity = crewCapacity;
    }

    /**
     * populate the Mapping between plane model and passenger capacity and crew capacity
     * @return Map with keys as model name, values as a list of (passenger capacity, crew capacity)
     */
    private static Map<String, List<Integer>> populateCapacityMap() {

        Map<String, List<Integer>> map = new HashMap<>();
        map.put("A380", Arrays.asList(500, 42));
        map.put("A350", Arrays.asList(320, 40));
        map.put("Embraer 190", Arrays.asList(25, 5));
        map.put("Antonov AN2", Arrays.asList(15, 3));
        return Collections.unmodifiableMap(map);
    }

    private void initializeCapacity() {
        String model = this.getModel();
        boolean isModelValid = CAPACITY_MAP.containsKey(model);

        if (isModelValid) {
            List<Integer> capacities = CAPACITY_MAP.get(model);
            this.setPassengerCapacity(capacities.get(0));
            this.setCrewCapacity(capacities.get(1));
        }
        else {
            throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }

}
