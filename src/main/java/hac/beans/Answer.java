package hac.beans;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents the answer that consists of a random 4-digit number.
 * and the message that the user gets after guessing number.
 */
@Component
public class Answer implements Serializable {
    /**
     * The correct number
     */
    private String answer;

    /**
     * The message that the user sees.
     */
    private String message;

    /**
     * Default constructor.
     */
    public Answer() {}

    /**
     * Constructor that sets the initial answer.
     * @param answer The initial answer.
     */
    public Answer(String answer) {
        this.answer = answer;
    }

    /**
     * Retrieves the answer.
     * @return The answer.
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Sets the answer.
     * @param answer The answer to set.
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Retrieves the message.
     * @return The message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     * @param message The message to set.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Generates a random 4-digit answer.
     */
    public void generateAnswer() {
        List<Integer> digits = new ArrayList<>();
        // Fill the list from 0-9 by order
        for (int i = 0; i < 10; i++) {
            digits.add(i);
        }

        Random random = new Random();
        String num = "";

        for (int i = 0; i < 4; i++) {
            int randomIndex = random.nextInt(digits.size()); // Generate a random number
            int digit = digits.remove(randomIndex); // Delete the number that we generated
            num+= digit;
        }
        this.answer = num;
    }
}
