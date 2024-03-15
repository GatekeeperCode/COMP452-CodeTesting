import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameOverGameTest {

    @Test
    void firstPass()
    {
        GameOverGame gog = new GameOverGame();
        assertEquals("I guessed it on the first try!", gog.gameOverMessage(1,true,false));
        assertEquals("You guessed it on the first try!", gog.gameOverMessage(1,true,true));
    }

    @Test
    void humanPassCheck()
    {
        GameOverGame gog = new GameOverGame();
        assertEquals("It took you 15 guesses.", gog.gameOverMessage(15, false, true));
        assertEquals("It took you 0 guesses.", gog.gameOverMessage(0, false, true));
        assertEquals("It took you 1 guesses.", gog.gameOverMessage(1, false, true));
        assertEquals("It took you 1234567890 guesses.", gog.gameOverMessage(1234567890, false, true));
        assertEquals("It took you -1 guesses.", gog.gameOverMessage(-1, false, true));
    }

    @Test
    void compPassCheck()
    {
        GameOverGame gog = new GameOverGame();
        assertEquals("It took me 15 guesses.", gog.gameOverMessage(15, false, false));
        assertEquals("It took me 0 guesses.", gog.gameOverMessage(0, false, false));
        assertEquals("It took me 1 guesses.", gog.gameOverMessage(1, false, false));
        assertEquals("It took me 1234567890 guesses.", gog.gameOverMessage(1234567890, false, false));
        assertEquals("It took me -1 guesses.", gog.gameOverMessage(-1, false, false));
    }
}
