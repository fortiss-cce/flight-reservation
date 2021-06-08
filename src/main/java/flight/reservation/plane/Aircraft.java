package flight.reservation.plane;

public abstract class Aircraft {
	protected String model;
	protected int passengerCapacity;
	protected int crewCapacity;

	public Aircraft(String model, int passengerCapacity, int crewCapacity) {
		this.model = model;
		this.passengerCapacity = passengerCapacity;
		this.crewCapacity = crewCapacity;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
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
}
