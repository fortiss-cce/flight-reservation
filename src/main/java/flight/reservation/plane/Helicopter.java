package flight.reservation.plane;

import java.util.*;

public class Helicopter extends Aircraft {

    private int passengerCapacity;
    private static final Map<String, Integer> CAPACITY_MAP;

    static {
        CAPACITY_MAP = Helicopter.populateCapacityMap();
    }

    public Helicopter(String model) {
        super(model);
        this.initializeCapacity();
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    /**
     * populate the Mapping between plane model and passenger capacity and crew capacity
     *
     * @return Map with keys as model name, values as a list of (passenger capacity, crew capacity)
     */
    private static Map<String, Integer> populateCapacityMap() {

        Map<String, Integer> map = new HashMap<>();
        map.put("H1", 4);
        map.put("H2", 6);
        return Collections.unmodifiableMap(map);
    }

    private void initializeCapacity() {
        String model = this.getModel();
        boolean isModelValid = CAPACITY_MAP.containsKey(model);

        if (isModelValid) {
            Integer capacity = CAPACITY_MAP.get(model);
            this.setPassengerCapacity(capacity);
        } else {
            throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }
}
