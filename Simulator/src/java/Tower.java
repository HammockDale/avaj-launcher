package src.java;

import java.util.ArrayList;
import java.util.List;

public class Tower {

    private final List<Flyable> observers = new ArrayList<>();
    public void register(Flyable flyable) {
        observers.add(flyable);
        if (this instanceof WeatherTower) {
            flyable.registerTower((WeatherTower) this);
        }
        Simulator.printCheck(flyable.toString() + " registered to weather tower.");

    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
//        System.out.println("Tower says: " + flyable.toString() + " unregistered from weather tower.");
        Simulator.printCheck("Tower says: " + flyable.toString() + " unregistered from weather tower.");

    }

    protected void conditionsChange() {
        for (Flyable f : new ArrayList<>(observers)) {
            f.updateConditions();
        }
    }
}
