public class CalculateTheResults {
    private int[] BIN_EDGES;
    private int numGames;

    public CalculateTheResults(int[] BIN_EDGES) {
        this.BIN_EDGES = BIN_EDGES;
    }

    public void updateResults(GameStats stats, int binIndex) {
        final int lowerBound = BIN_EDGES[binIndex];
        numGames = calculateNumGames(stats, binIndex, lowerBound);
    }

    private int calculateNumGames(GameStats stats, int binIndex, int lowerBound) {
        int numGames = 0;
        if (binIndex == BIN_EDGES.length - 1) {
            for (int numGuesses = lowerBound; numGuesses < stats.maxNumGuesses(); numGuesses++) {
                numGames += stats.numGames(numGuesses);
            }
        }
        else {
            int upperBound = BIN_EDGES[binIndex + 1];
            for (int numGuesses = lowerBound; numGuesses <= upperBound; numGuesses++) {
                numGames += stats.numGames(numGuesses);
            }
        }
        return numGames;
    }

    public int getNumGames() {
        return numGames;
    }
}
