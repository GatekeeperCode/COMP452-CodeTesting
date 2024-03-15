public class GameOverGame {
    GameOverGame(){}

    String gameOverMessage(int numGuesses, boolean firstTry, boolean humanWasPlaying)
    {
        return (firstTry ? (humanWasPlaying ? "You": "I") : "It took " + (humanWasPlaying ? "you":"me")) + " " + (firstTry ? "guessed it on the first try!" : numGuesses + " guesses.");
    }
}
