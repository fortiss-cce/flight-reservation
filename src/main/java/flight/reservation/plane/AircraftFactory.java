package flight.reservation.plane;

import java.util.HashMap;
import java.util.Set;
import java.util.function.Supplier;

public class AircraftFactory {

	private static HashMap<String, Supplier<Aircraft>> modelToCapacity = new HashMap<>() {{
		put("A380", () -> new PassengerPlane("A380", 500, 42));
		put("A350", () -> new PassengerPlane("A380", 320, 40));
		put("Embraer 190", () -> new PassengerPlane( "Embraer 190",25, 5));
		put("Antonov AN2", () -> new PassengerPlane("Antonov AN2",15, 3));
		put("H1", () -> new PessengerHelicopter("H1", 4, 2));
		put("H2", () -> new PessengerHelicopter("H2", 6, 2));
		put("HypaHype", () -> new PassengerDrone("HypaHype", 4, 0));
	}};

	public static Set<String> allAircraftTypes() {
		return modelToCapacity.keySet();
	}

	private static Aircraft createByType(String type){
		Supplier<Aircraft> supplier = modelToCapacity.get(type);
		if (supplier == null){
			throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", type));
		}
		return supplier.get();
	}

	public static PassengerPlane createA380(){
		return (PassengerPlane)createByType("A380");
	}

	public static PassengerPlane createA350(){
		return (PassengerPlane)createByType("A350");
	}

	public static PassengerPlane createEmbraer190(){
		return (PassengerPlane)createByType("Embraer 190");
	}

	public static PassengerPlane createAntonovAN2(){
		return (PassengerPlane)createByType("Antonov AN2");
	}

	public static PessengerHelicopter createH1Helicopter(){
		return (PessengerHelicopter)createByType("H1");
	}

	public static PessengerHelicopter createH2Helicopter(){
		return (PessengerHelicopter)createByType("H2");
	}

	public static PassengerDrone createDroneHypaHype(){
		return (PassengerDrone)createByType("HypaHype");
	}

}
