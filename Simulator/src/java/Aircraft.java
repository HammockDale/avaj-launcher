package src.java;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
//    private static long idCounter = 0l;  // TODO

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
        id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinate;
    }

//    private long nextId(){
//        return idCounter++;
//    }
}
