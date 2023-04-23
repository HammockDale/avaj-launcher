package src.java;

import java.io.*;


public class Simulator {
    final static String fileName = "simulation.txt";
    public static void main(String[] args) throws WrongArgumentException {
        if (args.length != 1) {
            throw new WrongArgumentException();
        }
        closeFile();

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            int count = Integer.parseInt(reader.readLine());
            if (count <= 0) {
                throw  new WrongParametersException();
            }
            String str;
            String[] mas;
            final WeatherTower tower = new WeatherTower();
            while ((str = reader.readLine()) != null) {
                mas = str.split(" ");
                if (mas.length != 5) {
                    throw new WrongParametersException();
                }
                int longitude = Integer.parseInt(mas[2]);
                int latitude = Integer.parseInt(mas[3]);
                int height = Integer.parseInt(mas[4]);
                if (height <= 0 || height > 100) {
                    throw new WrongParametersException();
                }
                Coordinates coordinates = new Coordinates(longitude, latitude, height);
                tower.register(AircraftFactory.newAircraft(mas[0], mas[1], coordinates));
            }
            for (int i = 0; i < count; i++) {
                tower.changeWeather();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void printCheck(String str) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.append(str);
            writer.append('\n');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void closeFile() {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.append("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
