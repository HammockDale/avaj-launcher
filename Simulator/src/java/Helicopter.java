package src.java;

public class Helicopter extends Aircraft implements Flyable{
    protected WeatherTower weatherTower;

    public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        int lg = coordinates.getLongitude();
        int lat = coordinates.getLatitude();
        int hei = coordinates.getHeight();
        if (hei <= 0) {
            return;
        }
        switch (weather) {
            case "RAIN":
                lg += 5;
                Simulator.printCheck(this + ": If you dream of a rainbow, be prepared to get caught in the rain.");
                break;
            case "SUN":
                lg += 10;
                hei += 2;
                Simulator.printCheck(this + ": Excellent visibility.");
                break;
            case "FOG":
                lg += 1;
                Simulator.printCheck(this + ": Cloudy with a Chance of Meatballs.");
                break;
            case "SNOW":
                hei -= 12;
                Simulator.printCheck(this + ": My rotor is going to freeze!");
                break;
        }
        if (hei <= 0) {
            Simulator.printCheck(this + ": Landing!");
            weatherTower.unregister(this);
            return;
        }
        this.coordinates = new Coordinates(lg, lat, hei);
    }

    @Override
    public void registerTower(WeatherTower p_tower) {

        this.weatherTower = p_tower;
//        System.out.println( "Helicopter#" + name + "(" + id + ") registered to weather tower.");
    }

    @Override
    public String toString() {
        return "Helicopter#" + name + '(' + id + ')' ;
    }
}
