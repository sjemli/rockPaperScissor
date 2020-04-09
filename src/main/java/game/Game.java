package game;

import enums.Move;
import enums.Result;
import players.ComputerPlayer;
import players.HumanPlayer;
import players.Player;

import static enums.Result.*;

//https://codereview.stackexchange.com/questions/90501/rock-paper-scissors
public class Game {

    public static final String CONTINUE_GAME_MESSAGE = "**** Would you like to continue ? Y - N ***";
    private final Player humanPlayer;
    private final Player computerPlayer;
    private int numberOfRounds;

    public Game(Player humanPlayer, Player computerPlayer) {
        this.humanPlayer = humanPlayer;
        this.computerPlayer = computerPlayer;
        numberOfRounds = 0;
    }

    public void playRound() {
        Move playerMove = humanPlayer.getChoice();
        Move computerMove = computerPlayer.getChoice();
        Result result = getRoundResult(playerMove, computerMove);
        updateWinnerScore(result);
        numberOfRounds++;
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


    private String getFinalResultMessage() {
        String finalResultMessage = "Player ==> " + humanPlayer.getScore() + " Computer ==> " + computerPlayer
                .getScore() + " after " + numberOfRounds + " rounds";
        return finalResultMessage;
    }

    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReader();
        Player humanPlayer = new HumanPlayer(consoleReader);
        Player computerPlayer = new ComputerPlayer();
        Game game = new Game(humanPlayer, computerPlayer);

        char keepPlaying = 'Y';
        while (keepPlaying == 'Y') {
            game.playRound();
            keepPlaying = consoleReader.readPlayerInput(CONTINUE_GAME_MESSAGE);
        }
        String finalResultMessage = game.getFinalResultMessage();
        System.out.println(finalResultMessage);
    }
}
