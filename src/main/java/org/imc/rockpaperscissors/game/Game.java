package org.imc.rockpaperscissors.game;

import org.imc.rockpaperscissors.enums.Move;
import org.imc.rockpaperscissors.enums.Result;
import org.imc.rockpaperscissors.players.ComputerPlayer;
import org.imc.rockpaperscissors.players.HumanPlayer;
import org.imc.rockpaperscissors.players.Player;

import java.util.stream.IntStream;

import static org.imc.rockpaperscissors.enums.Result.*;


public class Game {

    private static final String MAXIMUM_NUMBER_OF_ROUNDS_MESSAGE = "**** How many rounds do you want to play? : ***";

    private final Player humanPlayer;
    private final Player computerPlayer;
    private final ConsoleReader consoleReader;
    private int maximumNumberOfRounds;

    public Game() {
        this.consoleReader = new ConsoleReader();
        this.humanPlayer = new HumanPlayer(consoleReader);
        this.computerPlayer = new ComputerPlayer();
        this.maximumNumberOfRounds = 0;
    }

    public Game(Player humanPlayer, Player computerPlayer, ConsoleReader consoleReader) {
        this.humanPlayer = humanPlayer;
        this.computerPlayer = computerPlayer;
        this.consoleReader = consoleReader;
        this.maximumNumberOfRounds = 0;
    }

    void playRound(int roundNumber) {
        Move playerMove = humanPlayer.getChoice();
        Move computerMove = computerPlayer.getChoice();
        Result result = getRoundResult(playerMove, computerMove);
        updateWinnerScore(result);
        System.out.printf("Round Number = %s , You chose %s , Computer chose %s %n %s %n", roundNumber, playerMove, computerMove, result);
    }

    private void updateWinnerScore(Result result) {
        if (result == WIN) {
            humanPlayer.incrementScore();
        } else if (result == LOSS) {
            computerPlayer.incrementScore();
        }
    }

    private Result getRoundResult(Move playerMove, Move computerMove) {
        if (computerMove == playerMove) return TIE;
        else if (playerMove.beats(computerMove)) return WIN;
        else return LOSS;
    }

    public void play() {
        fillMaximumNumberOfRounds();

        IntStream.rangeClosed(1, maximumNumberOfRounds).forEach(this::playRound);

        System.out.printf("Final Score :%n Player ==> %s  ,Computer ==> %s , after %s rounds", humanPlayer.getScore(),
                computerPlayer.getScore(), maximumNumberOfRounds);
    }

    private void fillMaximumNumberOfRounds() {
        maximumNumberOfRounds = consoleReader.readNumberOfRounds(MAXIMUM_NUMBER_OF_ROUNDS_MESSAGE);
        System.out.printf("You will play %s rounds %n", maximumNumberOfRounds);
    }

    int getMaximumNumberOfRounds() {
        return maximumNumberOfRounds;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }

}
