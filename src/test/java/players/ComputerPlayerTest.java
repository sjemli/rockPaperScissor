package players;

import enums.Move;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.reflection.FieldSetter;

import java.lang.reflect.Field;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ComputerPlayerTest {

    private Random randomMock;
    private Player computerPlayer;

    @BeforeEach
    private void init() throws NoSuchFieldException {
        randomMock = mock(Random.class);
        computerPlayer = new ComputerPlayer();
        Field declaredField = computerPlayer.getClass().getDeclaredField("random");
        FieldSetter.setField(computerPlayer,
                declaredField,
                randomMock);
    }

    @Test
    public void should_(){
        when(randomMock.nextInt()).thenReturn(35);
        Move computerPlayerChoice = computerPlayer.getChoice();
        assertThat(computerPlayerChoice, equalTo(Move.SCISSORS));

    }

    @Test
    public void  te(){
        assertThat(computerPlayer.getScore(), equalTo(0));
        computerPlayer.incrementScore();
        assertThat(computerPlayer.getScore(), equalTo(1));


    }

}