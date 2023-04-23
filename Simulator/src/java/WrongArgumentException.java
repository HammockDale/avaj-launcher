package src.java;

public class WrongArgumentException extends RuntimeException {
    public WrongArgumentException() {
        super("This program will take one and only one argument from the command line. \n" +
                "This argument represents the name of a text file that will contain the scenario that needs to be simulated");
    }
}
