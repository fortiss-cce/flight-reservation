package flight.reservation.plane;

import java.util.Arrays;
import java.util.List;

public class PassengerDrone extends Aircraft {
    private static final List<String> VALID_MODELS = Arrays.asList("HypaHype");

    public PassengerDrone(String model) {
        super(model);
        this.validateModel();
    }

    private void validateModel() {
        String model = this.getModel();

        if (! VALID_MODELS.contains(model)) {
            throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }
}
