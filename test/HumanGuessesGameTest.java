import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HumanGuessesGameTest {
    int testValue = 836; //using dependency injection

    @Test
    void makeGuessTest()
    {
        HumanGuessesGame hgg = new HumanGuessesGame(testValue); //using dependency injection

        assertEquals(GuessResult.LOW, hgg.makeGuess(835));
        assertEquals(GuessResult.LOW, hgg.makeGuess(0));
        assertEquals(GuessResult.LOW, hgg.makeGuess(257));
        assertEquals(GuessResult.LOW, hgg.makeGuess(-1));

        assertEquals(GuessResult.HIGH, hgg.makeGuess(837));
        assertEquals(GuessResult.HIGH, hgg.makeGuess(1000));
        assertEquals(GuessResult.HIGH, hgg.makeGuess(897));
        assertEquals(GuessResult.HIGH, hgg.makeGuess(1093820));

        assertEquals(GuessResult.CORRECT, hgg.makeGuess(836));
    }

    @Test
    void getNumGuessesTest()
    {
        HumanGuessesGame hgg = new HumanGuessesGame(testValue); //using dependency injection

        assertEquals(0, hgg.getNumGuesses());
        hgg.makeGuess(1);
        hgg.makeGuess(1);
        hgg.makeGuess(1);
        assertEquals(3, hgg.getNumGuesses());
        hgg.makeGuess(1);
        hgg.makeGuess(1);
        hgg.makeGuess(1);
        hgg.makeGuess(1);
        hgg.makeGuess(1);
        hgg.makeGuess(1);
        hgg.makeGuess(1);
        assertEquals(10, hgg.getNumGuesses());
    }

    @Test
    void isDoneTest()
    {
        HumanGuessesGame hgg = new HumanGuessesGame(testValue); //using dependency injection

        assertEquals(false, hgg.isDone());
        hgg.makeGuess(835); //Guess Incorrect Value
        assertEquals(false, hgg.isDone());
        hgg.makeGuess(836); //Guess correct value
        assertEquals(true, hgg.isDone());
    }
}
