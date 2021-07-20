package flight.reservation.plane;

public class Plane {

    private int passengerCapacity;
    private int crewCapacity;
    private String model;

    public Plane(String model) {
        this.model = model;
        this.passengerCapacity = -1;
        this.crewCapacity = -1;
    }

    public void setPassengerCapacity(int passengerCapacity){
        this.passengerCapacity = passengerCapacity;
    }

    public void setCrewCapacity(int crewCapacity){
        this.crewCapacity = crewCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public int getCrewCapacity() {
        return crewCapacity;
    }

    public String getModel() {
        return model;
    }

    public void checkModel(String model){
        //To be implemented by each subclass.
    };
}
