public class ComputerGuessesGame {

    // upperBound and lowerBound track the computer's knowledge about the correct number
    // They are updated after each guess is made
    private int upperBound; // correct number is <= upperBound
    private int lowerBound; // correct number is >= lowerBound

    ComputerGuessesGame(){
        upperBound = 1000;
        lowerBound = 1;
    }

    int higherGuess(int lastGuess)
    {
        upperBound = Math.min(upperBound, lastGuess);
        return (lowerBound + upperBound + 1) / 2;
    }

    int lowerGuess(int lastGuess)
    {
        lowerBound = Math.max(lowerBound, lastGuess + 1);
        return (lowerBound + upperBound + 1) / 2;
    }

    int guessMaker()
    {
        upperBound = 1000;
        lowerBound = 1;

        return (lowerBound + upperBound + 1) / 2;
    }
}
