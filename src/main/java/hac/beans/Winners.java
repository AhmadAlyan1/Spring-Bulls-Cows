package hac.beans;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a collection of winner details.
 */
@Component
public class Winners  implements Serializable {

    /**
     * ArrayList to save the winners (names, and scores)
     */
    private ArrayList<WinnerDetails> winners;

    /**
     * Gets the list of winner details.
     *
     * @return The list of winners.
     */
    public ArrayList<WinnerDetails> getWinners() {
        return winners;
    }

    /**
     * Sets the list of winners.
     *
     * @param winners The list of winner details to set.
     */
    public void setWinners(ArrayList<WinnerDetails> winners) {
        this.winners = winners;
    }

    /**
     * Add a winner details to the collection.
     *
     * @param winnerDetails The winner details to add.
     */
    public void add(WinnerDetails winnerDetails) {
        winners.add(winnerDetails);
    }

}
