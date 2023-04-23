package src.java;

public class WeatherProvidar {

    private static final String[] weather = {
            "RAIN",
            "FOG",
            "SUN",
            "SNOW"
    };

    private WeatherProvidar(){
    }

    public static String getCurrentWeather(Coordinates p_coordinates) {
        int generator = p_coordinates.getHeight() + p_coordinates.getLatitude() + p_coordinates.getLongitude();
        return weather[generator % 4];
    }

}
