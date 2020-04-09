package players;

import enums.Move;

import java.util.Random;

public class ComputerPlayer extends Player {

    private final Random random;

    public ComputerPlayer() {
        this.random = new Random();
    }

    @Override
    public Move getChoice() {
        int randomMove = random.nextInt() % 3;
        return Move.values[randomMove];
    }
}
