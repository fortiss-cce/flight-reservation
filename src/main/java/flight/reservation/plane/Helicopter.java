package flight.reservation.plane;

public class Helicopter implements Aircraft {
    enum Model {
        H1, H2
    }

    private final Model model;

    public Helicopter(String model) {
        if (model.equals("H1")) {
            this.model = Model.H1;
        } else if (model.equals("H2")) {
            this.model = Model.H2;
        } else {
            throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }

    @Override
    public String getModel() {
        switch (model) {
            case H1:
                return "H1";
            case H2:
                return "H2";
        }
        throw new IllegalStateException("Illegal model");
    }

    @Override
    public int getPassengerCapacity() {
        switch (model) {
            case H1:
                return 4;
            case H2:
                return 6;
        }
        throw new IllegalStateException("Illegal model");
    }

    @Override
    public int getCrewMemberCapacity() {
        return 2;
    }

}
