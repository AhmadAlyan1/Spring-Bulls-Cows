package hac.beans;


import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Represents the user's guess for a game.
 */
@Component
public class UserGuess implements Serializable{
    /**
     * First-digit
     */
    int num1 = -1;
    /**
     * Second-digit
     */
    int num2 = -1;
    /**
     * Third-digit
     */
    int num3 = -1;
    /**
     * Fourth-digit
     */
    int num4 = -1;

    /**
     * Gets the value of the first digit in the guess.
     *
     * @return The value of the first digit.
     */
    public int getNum1() {
        return num1;
    }

    /**
     * Sets the value of the first digit in the guess.
     *
     * @param num1 The value of the first digit.
     */
    public void setNum1(int num1) {
        this.num1 = num1;
    }

    /**
     * Gets the value of the second digit in the guess.
     *
     * @return The value of the second digit.
     */
    public int getNum2() {
        return num2;
    }

    /**
     * Sets the value of the second digit in the guess.
     *
     * @param num2 The value of the second digit.
     */
    public void setNum2(int num2) {
        this.num2 = num2;
    }

    /**
     * Gets the value of the third digit in the guess.
     *
     * @return The value of the third digit.
     */
    public int getNum3() {
        return num3;
    }

    /**
     * Sets the value of the third digit in the guess.
     *
     * @param num3 The value of the third digit.
     */
    public void setNum3(int num3) {
        this.num3 = num3;
    }

    /**
     * Gets the value of the fourth digit in the guess.
     *
     * @return The value of the fourth digit.
     */
    public int getNum4() {
        return num4;
    }

    /**
     * Sets the value of the fourth digit in the guess.
     *
     * @param num4 The value of the fourth digit.
     */
    public void setNum4(int num4) {
        this.num4 = num4;
    }

    /**
     * Checks if the guess contains duplicated digits.
     *
     * @return true if there are duplicated digits, false otherwise.
     */
    public boolean isDuplicated() {
        // Check if numbers are duplicated
        if (num1 == num2 || num1 == num3 || num1 == num4 ||
                num2 == num3 || num2 == num4 ||
                num3 == num4)
            return true;

        return false;
    }

    /**
     * Returns a string representation of the guess.
     *
     * @return The string representation of the guess.
     */
    public String toString() {
        return ("" + num1 + num2 + num3 + num4);
    }
}
