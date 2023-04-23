package src.java;

public class Baloon extends Aircraft implements Flyable {

    protected WeatherTower weatherTower;
    public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    @Override
    public void updateConditions() // throws IOException
    {
        String weather = weatherTower.getWeather(coordinates);
        int lg = coordinates.getLongitude();
        int lat = coordinates.getLatitude();
        int hei = coordinates.getHeight();
        if (hei <= 0) {
            return;
        }
        switch (weather) {
            case "RAIN":
                hei -= 5;
                Simulator.printCheck(this + ": Rain, rain go away, come back another day.");
                break;
            case "SUN":
                lg += 2;
                hei += 4;
                Simulator.printCheck(this + ": It's wonderful weather, isn't it?");
                break;
            case "FOG":
                hei -= 3;
                Simulator.printCheck(this + ": The hedgehog came out of the fog...");
                break;
            case "SNOW":
                hei -= 15;
                Simulator.printCheck(this + ": The snow fell earlier because nature couldn't stand another season of foliage photos.");
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
//        Flyable.super.
//                super.
        weatherTower = p_tower;
    }

    @Override
    public String toString() {
        return "Baloon#" + name + '(' + id + ')' ;
    }
}
