package src.java;

public class JetPlane extends Aircraft implements Flyable{

    protected WeatherTower weatherTower;
    JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
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
                lat += 5;
                Simulator.printCheck(this + ": It's raining. Better watch out for lightings.");
                break;
            case "SUN":
                lg += 10;
                hei += 2;
                Simulator.printCheck(this + ": Let's enjoy the good weather and take some pics.");
                break;
            case "FOG":
                lat += 1;
                Simulator.printCheck(this + ": Turn on the marker lights.");
                break;
            case "SNOW":
                hei -= 7;
                Simulator.printCheck(this + ": White flies!");
                break;
        }
        if (hei <= 0) {
            Simulator.printCheck(this + ": Landing!");
            this.weatherTower.unregister(this);
            return;
        }
        this.coordinates = new Coordinates(lg, lat, hei);
    }

    @Override
    public void registerTower(WeatherTower p_tower) {
        this.weatherTower = p_tower;
//        System.out.println( "JetPlane#" + name + "(" + id + ") registered to weather tower.");
    }

    @Override
    public String toString() {
        return "JetPlane#" + name + '(' + id + ')' ;
    }
}
