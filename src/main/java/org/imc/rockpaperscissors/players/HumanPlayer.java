package org.imc.rockpaperscissors.players;


import org.imc.rockpaperscissors.enums.Move;
import org.imc.rockpaperscissors.game.ConsoleReader;

import java.util.Optional;

public class HumanPlayer extends Player {

    private static final String HUMAN_MOVE_INPUT_MESSAGE = "Enter move code : R => Rock, P => Paper, S => Scissors";
    private final ConsoleReader consoleReader;

    public HumanPlayer(ConsoleReader consoleReader) {
        this.consoleReader = consoleReader;
    }

    public HumanPlayer() {
        this(new ConsoleReader());
    }

    @Override
    public Move getChoice() {

        Optional<Move> move = Optional.empty();
        while (!move.isPresent()) {
            move = Move.fromMnemonic(consoleReader.readPlayerMove(HUMAN_MOVE_INPUT_MESSAGE));
        }
        return move.get();
    }


}
