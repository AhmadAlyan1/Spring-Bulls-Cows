package hac.beans;

import jakarta.persistence.*;
import java.io.Serializable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.stereotype.Component;

/**
 * Represents the details of a winner.
 */
@Entity
@Component
public class WinnerDetails implements Serializable {
    /**
     * ID of the winner
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the winner
     */
    @Column(nullable = false, unique = true)
    @NotNull
    @NotEmpty(message = "Name is mandatory")
    private String name;

    /**
     * The score of the winner
     */
    @PositiveOrZero(message = "Score not negative")
    private int score = 0;

    /**
     * constructor
     * @param name the name
     * @param score the score
     */
    public WinnerDetails(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * Default constructor for WinnerDetails.
     */
    public WinnerDetails() {
    }

    /**
     * Returns the ID of the winner.
     *
     * @return the ID of the winner
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the winner.
     *
     * @param id the ID of the winner
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the name of the winner.
     *
     * @return the name of the winner
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the winner.
     *
     * @param name the name of the winner
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the score of the winner.
     *
     * @return the score of the winner
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the score of the winner.
     *
     * @param score the score of the winner
     */
    public void setScore(int score) {
        this.score = score;
    }

}


