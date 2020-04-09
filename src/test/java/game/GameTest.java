package game;

import enums.Move;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import players.ComputerPlayer;
import players.HumanPlayer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

class GameTest {

    private Game game;
    private HumanPlayer humanPlayerSpy;
    private ComputerPlayer computerPlayerSpy;

    @BeforeEach
    void init() {
        humanPlayerSpy = spy(HumanPlayer.class);
        computerPlayerSpy = spy(ComputerPlayer.class);
        game = new Game(humanPlayerSpy, computerPlayerSpy);

    }

    @Test
    void testplayRound() {
        //Given
        doReturn(Move.ROCK).when(humanPlayerSpy).getChoice();
        doReturn(Move.PAPER).when(computerPlayerSpy).getChoice();

        //when
        game.playRound();

        //then
        verify(computerPlayerSpy).incrementScore();
        assertThat(computerPlayerSpy.getScore(), equalTo(1));
        assertThat(humanPlayerSpy.getScore(), equalTo(0));

    }

    @Test
    void testplayRound2() {
        //Given
        doReturn(Move.SCISSORS).when(humanPlayerSpy).getChoice();
        doReturn(Move.PAPER).when(computerPlayerSpy).getChoice();

        //when
        game.playRound();

        //then
        verify(humanPlayerSpy).incrementScore();
        assertThat(computerPlayerSpy.getScore(), equalTo(0));
        assertThat(humanPlayerSpy.getScore(), equalTo(1));

    }
}
