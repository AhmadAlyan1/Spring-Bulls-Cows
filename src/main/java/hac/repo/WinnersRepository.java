package hac.repo;

import hac.beans.WinnerDetails;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

/**
 * Repository interface for managing WinnerDetails entities.
 */
public interface WinnersRepository extends JpaRepository<WinnerDetails, Long> {

    /**
     * Checks if a WinnerDetails entity with the specified name exists.
     *
     * @param name the name to check
     * @return true if a WinnerDetails entity with the name exists, false otherwise
     */
    boolean existsByName(String name);

    /**
     * Retrieves the first 5 WinnerDetails entities ordered by score in ascending order.
     *
     * @return a list of the first 5 WinnerDetails entities ordered by score
     */
    List<WinnerDetails> findFirst5ByOrderByScoreAsc();
}
