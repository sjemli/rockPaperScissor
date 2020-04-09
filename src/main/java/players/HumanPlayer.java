package players;

import enums.Move;
import game.ConsoleReader;

import java.util.Optional;

public class HumanPlayer extends Player {

    public static final String MOVE_INPUT_MESSAGE = "Enter move code : R => Rock, P => Paper, S => Scissors";
    private final ConsoleReader consoleReader;

    public HumanPlayer(ConsoleReader consoleReader) {
        this.consoleReader = consoleReader;
    }

    public HumanPlayer() {
        this.consoleReader = new ConsoleReader();
    }

    @Override
    public Move getChoice() {

        Optional<Move> move = Optional.empty();
        while (!move.isPresent()) {
            move = Move.fromMnemonic(consoleReader.readPlayerInput(MOVE_INPUT_MESSAGE));
        }
        return move.get();
    }


}
