package src.java;

public final class WeatherTower extends Tower {


    public String getWeather(Coordinates p_coordinates) {
        return WeatherProvidar.getCurrentWeather(p_coordinates);
    }

    public void changeWeather() {
        this.conditionsChange();

    }
}
