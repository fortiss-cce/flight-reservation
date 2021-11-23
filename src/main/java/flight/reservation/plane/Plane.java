package flight.reservation.plane;

public abstract class Plane {
    protected String model;
    protected int passengerCapacity;
    protected int crewCapacity;



    public int getCrewMemberCapacity()
    {
        return crewCapacity;
    }

    public int getPassengerCapacity()
    {
        return passengerCapacity;
    }

    public String getModel() {
        return model;
    }


    /**
     public int getCrewMemberCapacity() throws NoSuchFieldException {
     if (this.aircraft instanceof PassengerPlane) {
     return ((PassengerPlane) this.aircraft).crewCapacity;
     }
     if (this.aircraft instanceof Helicopter) {
     return 2;
     }
     if (this.aircraft instanceof PassengerDrone) {
     return 0;
     }
     throw new NoSuchFieldException("this aircraft has no information about its crew capacity");
     }
     */


    /**
     public int getCapacity() throws NoSuchFieldException {
     if (this.aircraft instanceof PassengerPlane) {
     return ((PassengerPlane) this.aircraft).passengerCapacity;
     }
     if (this.aircraft instanceof Helicopter) {
     return ((Helicopter) this.aircraft).getPassengerCapacity();
     }
     if (this.aircraft instanceof PassengerDrone) {
     return 4;
     }
     throw new NoSuchFieldException("this aircraft has no information about its capacity");
     }
     */





    /**
     private boolean isAircraftValid(Airport airport) {
     return Arrays.stream(airport.getAllowedAircrafts()).anyMatch(x -> {
     String model;
     if (this.aircraft instanceof PassengerPlane) {
     model = ((PassengerPlane) this.aircraft).model;
     } else if (this.aircraft instanceof Helicopter) {
     model = ((Helicopter) this.aircraft).getModel();
     } else if (this.aircraft instanceof PassengerDrone) {
     model = "HypaHype";
     } else {
     throw new IllegalArgumentException(String.format("Aircraft is not recognized"));
     }
     return x.equals(model);
     });
     }
     */
}
