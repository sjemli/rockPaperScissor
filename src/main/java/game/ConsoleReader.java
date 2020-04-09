package game;

import java.util.Scanner;

public class ConsoleReader {

    private final Scanner inputScanner;


    public ConsoleReader() {
        this.inputScanner = new Scanner(System.in);
    }

    public char readPlayerInput(String inputMessage) {
        System.out.println(inputMessage);
        return inputScanner.nextLine().toUpperCase().charAt(0);
    }
}
