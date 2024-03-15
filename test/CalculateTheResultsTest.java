import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateTheResultsTest {
    private CalculateTheResults calculateTheResults;
    private final int[] BIN_EDGES = { 1, 5, 10 };
    private GameStats fakeStats;

    @BeforeEach
    public void setUp() { //runs before each @Test
        fakeStats = new GameStats() {
            @Override
            public int maxNumGuesses() {
                return 1;
            }

            @Override
            public int numGames(int numGuesses) {
                return numGuesses;
            }

        };
        calculateTheResults = new CalculateTheResults(BIN_EDGES);
    }

    @Test
    public void updateResultsTest() {
        // still working on this
        calculateTheResults.updateResults(fakeStats, 0);
        assertEquals(15, calculateTheResults.getNumGames());


    }

}
