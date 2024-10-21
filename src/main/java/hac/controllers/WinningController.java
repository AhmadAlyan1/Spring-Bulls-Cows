package hac.controllers;

import hac.beans.WinnerDetails;
import hac.repo.WinnersRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

/**
 * Winning controller
 */
@Controller
public class WinningController {

    /**
     * this is the JPA repository (SQL database)
     */
    @Autowired
    private WinnersRepository repository;

    /**
     * winnerDetailsSession
     */
    @Autowired
    @Qualifier("sessionWinnerDetails")
    private WinnerDetails winnerDetailsSession;

    /**
     * GET request for the main page after winning.
     * Displays the score achieved by the winner, and a form
     * to enter the player name.
     *
     * @param model the model object for the view
     * @return the name of the view to render
     */
    @GetMapping("/won")
    public String getWon(Model model) {
        model.addAttribute("showNames", false); // Dont show winners table
        model.addAttribute("score", winnerDetailsSession.getScore()); // Show score
        return "win";
    }

    /**
     * POST request for saving the winner's name and score.
     * Checks if the name already exists in the repository before saving.
     *
     * @param model          the model object for the view
     * @param winnerDetails  the winner details to be saved
     * @return the name of the view to render
     */
    @PostMapping("/winners")
    public String postWinnerName(Model model,
            @Valid WinnerDetails winnerDetails) {
        // Set score
        winnerDetails.setScore(winnerDetailsSession.getScore());
        // Check if name is not exist before
        if (!repository.existsByName(winnerDetails.getName())) {
            // If valid add to dataBase
            repository.save(new WinnerDetails(winnerDetails.getName(), winnerDetails.getScore()));
        }
        // Tell the user to change the name
        else {
            model.addAttribute("showNames", false);
            model.addAttribute("message", "Name exist, please select another name");
            model.addAttribute("score", winnerDetails.getScore());
            return "win";
        }
        return "redirect:/winners";
    }

    /**
     * GET request for displaying the first 5 winners sorted by score.
     *
     * @param model the model object for the view
     * @return the name of the view to render
     */
    @GetMapping("/winners")
    public String getFirst5Winners(
            Model model) {
        model.addAttribute("showNames", true);

        // View top 5 scores
        model.addAttribute("winners", repository.findFirst5ByOrderByScoreAsc());
        return "win";
    }

    /**
     * GET request for displaying all winners' names.
     * This endpoint is accessible to admin only.
     *
     * @param model the model object for the view
     * @return the name of the view to render
     */
    @GetMapping("/admin/winners")
    public String getAllWinnersNames(
            Model model) {
        model.addAttribute("showNames", true);

        // View all the scores
        model.addAttribute("winners", repository.findAll());
        return "win";
    }

    /**
     * POST request for deleting all winners' records from the repository.
     * This endpoint is accessible to admin only.
     *
     * @param model the model object for the view
     * @return the name of the view to render
     */
    @PostMapping("/admin/deleteTable")
    public String postDeleteTable(Model model) {
        model.addAttribute("showNames", true);

        repository.deleteAll(); // Delete all scores
        model.addAttribute("winners", repository.findAll());
        return "win";
    }

    /**
     * POST request for deleting a specific player's record from the repository.
     * This endpoint is accessible to admin only.
     *
     * @param model       the model object for the view
     * @param playerName  the ID of the player to be deleted
     * @return the name of the view to render
     */
    @PostMapping("/admin/deletePlayer")
    public String postDeletePlayer(Model model,
                                   @RequestParam("playerName") Long playerName) {
        model.addAttribute("showNames", true);
        repository.deleteById(playerName); // Delete score by id

        // View all the scores
        model.addAttribute("winners", repository.findAll());
        return "win";
    }

    /**
     * Exception handler method to handle the ChangeSetPersister.NotFoundException.
     * Renders the error view with an error message.
     *
     * @param ex The NotFoundException thrown
     * @return A ModelAndView object representing the error view
     */
    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ModelAndView handleNotFoundException(ChangeSetPersister.NotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }
}
