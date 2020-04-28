package org.imc.rockpaperscissors.players;

import org.imc.rockpaperscissors.enums.Move;

import java.util.Random;

public class ComputerPlayer extends Player {

    private final Random random;

    public ComputerPlayer() {
        this.random = new Random();
    }

    @Override
    public Move getChoice() {
        int randomMove = Math.abs(random.nextInt() % 3);
        return Move.values()[randomMove];
    }
}
