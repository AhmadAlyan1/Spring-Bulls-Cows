package hac.beans;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Represents a table row containing a guess, number of bulls, and number of cows.
 */
@Component
public class TableRow implements Serializable {

    /**
     * The number that the user guessed
     */
    private String guess = "";

    /**
     * How many bulls
     */
    private int bulls = 0;

    /**
     * How many cows
     */
    private int cows = 0;

    /**
     * Default constructor.
     */
    public TableRow() {}

    /**
     * Constructs a table row with the specified guess, number of bulls, and number of cows.
     *
     * @param guess The user guess.
     * @param bulls The number of bulls.
     * @param cows  The number of cows.
     */
    public TableRow(String guess, int bulls, int cows) {
        this.guess = guess;
        this.bulls = bulls;
        this.cows = cows;
    }

    /**
     * Gets the guess.
     *
     * @return The guess.
     */
    public String getGuess() {
        return guess;
    }

    /**
     * Sets the guess.
     *
     * @param guess The guess to set.
     */
    public void setGuess(String guess) {
        this.guess = guess;
    }

    /**
     * Gets the number of cows.
     *
     * @return The number of cows.
     */
    public int getCows() {
        return cows;
    }

    /**
     * Sets the number of cows.
     *
     * @param cows The number of cows to set.
     */
    public void setCows(int cows) {
        this.cows = cows;
    }

    /**
     * Gets the number of bulls.
     *
     * @return The number of bulls.
     */
    public int getBulls() {
        return bulls;
    }

    /**
     * Sets the number of bulls.
     *
     * @param bulls The number of bulls to set.
     */
    public void setBulls(int bulls) {
        this.bulls = bulls;
    }

    /**
     * Handles the guess by comparing it to the answer and determining the number of bulls and cows.
     *
     * @param answer The answer to compare the guess with.
     */
    public void handleGuess(String answer) {
        this.cows = 0;
        this.bulls = 0;
        // Check the 4-digits number
        for (int i = 0; i < 4; i++) {
            char digit = this.guess.charAt(i); // The i-digit

            // If in the same place bulls++
            if (digit == answer.charAt(i)) {
                this.bulls ++;
            }
            // If the digit is in the answer but in another place cows++
            else if (answer.contains(Character.toString(digit))) {
                this.cows ++;
            }
        }
    }
}
