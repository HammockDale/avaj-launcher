package src.java;

public class AircraftFactory {

    private static long idCounter = 0L;

    public static Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates)  throws WrongFlyableException {

        Flyable flyable;

        switch (p_type) {
            case "Baloon":
                flyable = new Baloon(idCounter++, p_name, p_coordinates);
                break;
            case "JetPlane":
                flyable = new JetPlane(idCounter++, p_name, p_coordinates);
                break;
            case "Helicopter":
                flyable = new Helicopter(idCounter++, p_name, p_coordinates);
                break;
            default:
                throw new WrongFlyableException();
        }
        return flyable;
    }
}
