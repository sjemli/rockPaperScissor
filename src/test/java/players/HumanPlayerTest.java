package players;

import enums.Move;
import game.ConsoleReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HumanPlayerTest {


    private ConsoleReader consoleReader;
    private Player humanPlayer;

    @BeforeEach
    private void init(){
        consoleReader = mock(ConsoleReader.class);
        humanPlayer = new HumanPlayer(consoleReader);
    }
    @Test
    public void should_return_SCISSOR_hen_input_is_s() {
        //Given
        when(consoleReader.readPlayerInput(anyString())).thenReturn('S');
        //when
        Move playerMove = humanPlayer.getChoice();
        //then
        assertThat(playerMove, equalTo(Move.SCISSORS));
    }

    @Test
    public void should_return_ROCK_hen_input_is_r() {
        //Given
        when(consoleReader.readPlayerInput(anyString())).thenReturn('R');
        //when
        Move playerMove = humanPlayer.getChoice();
        //then
        assertThat(playerMove, equalTo(Move.ROCK));
    }

    @Test
    public void should_return_PAPER_hen_input_is_p() {
        //Given
        when(consoleReader.readPlayerInput(anyString())).thenReturn('P');
        //when
        Move playerMove = humanPlayer.getChoice();
        //then
        assertThat(playerMove, equalTo(Move.PAPER));
    }

}