package flight.reservation.plane;

import java.util.ArrayList;
import java.util.Arrays;

public class AircraftFactory {

    public static ArrayList<String> getAllowedModels(){
        return new ArrayList<>(Arrays.asList("A380", "A350", "Embraer 190", "Antonov AN2", "H1", "H2", "HypaHype"));
    }

    public static Aircraft create(String model) throws IllegalArgumentException {
        switch(model){
            case "A380":
                return new Aircraft(model, 500, 42);
            case "A350":
                return new Aircraft(model, 320, 40);
            case "Embraer 190":
                return new Aircraft(model, 25, 5);
            case "Antonov AN2":
                return new Aircraft(model, 15, 3);
            case "H1":
                return new Aircraft(model, 4, 2);
            case "H2":
                return new Aircraft(model, 6, 2);
            case "HypaHype":
                return new Aircraft(model, 4, 0);
            default:
                throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }

}
