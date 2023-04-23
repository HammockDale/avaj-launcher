package src.java;

public class WrongFlyableException extends RuntimeException {
    public WrongFlyableException() {
        super("This Flyable is not found.");
    }
}