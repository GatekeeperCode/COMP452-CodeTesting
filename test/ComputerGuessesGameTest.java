import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComputerGuessesGameTest {

    @Test
    void higherGuessTest()
    {
        ComputerGuessesGame cgg = new ComputerGuessesGame();

        //Assuming cgg.lowerGuess = 1;
        assertEquals(750, cgg.higherGuess(500));
        assertEquals(1, cgg.higherGuess(2));
        assertEquals(500, cgg.higherGuess(1000));
    }

    @Test
    void lowerGuessTest()
    {
        ComputerGuessesGame cgg = new ComputerGuessesGame();

        //Assuming cgg.higherGuess=1000
        assertEquals(250, cgg.lowerGuess(500));
        assertEquals(500, cgg.lowerGuess(1));
        assertEquals(1000, cgg.lowerGuess(999));
    }

    @Test
    void guessMaker()
    {
        ComputerGuessesGame cgg = new ComputerGuessesGame();

        assertEquals(500, cgg.guessMaker());
        cgg.lowerGuess(500); //For Variance of testing
        assertEquals(250, cgg.guessMaker());
        cgg = new ComputerGuessesGame();
        cgg.higherGuess(500);
        assertEquals(750, cgg.guessMaker());
    }
}
