package hac.controllers;

import hac.beans.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Game controller
 */
@Controller
public class GameController {

    /**
     * answerSession
     */
    @Autowired
    @Qualifier("sessionAnswer")
    private Answer answerSession;

    /**
     * tablSession
     */
    @Autowired
    @Qualifier("sessionTable")
    private Table tablSession;

    /**
     * winnerDetailsSession
     */
    @Autowired
    @Qualifier("sessionWinnerDetails")
    private WinnerDetails winnerDetailsSession;

    /**
     * Handles the GET request for the main page.
     *
     * @param model the model object for the view
     * @return the name of the view template
     */
    @GetMapping("/")
    public String getMainPage(Model model) {
        // Reset all
        tablSession.clear();
        winnerDetailsSession.setScore(0);
        answerSession.generateAnswer();
        System.out.println("Answer = " + answerSession.getAnswer()); // print answer in console
        model.addAttribute("message", "Your history of guesses will appear below:");
        model.addAttribute("guess", new UserGuess());
        model.addAttribute("answer", answerSession.getAnswer());
        return "index";
    }

    /**
     * Handles the GET request for the login page.
     *
     * @param model the model object for the view
     * @return the name of the view template for login page
     */
    @GetMapping("/login")
    public String getLogin(Model model) {
        return "login";
    }

    /**
     * Handles the POST request for submitting a guess.
     *
     * @param userGuess the user's guess
     * @param model     the model object for the view
     * @return the name of the view template
     */
    @PostMapping("/guess")
    public String postGuess(@Valid UserGuess userGuess, Model model) {
        // Convert String to int
        int number = userGuess.getNum1() * 1000 + userGuess.getNum2() * 100 + userGuess.getNum3() * 10 + userGuess.getNum4();
        // If not all digits choosed
        if (number < 0)
            answerSession.setMessage("Please select 4 digits!");

        else {
            // If there is duplicated digits
            if (userGuess.isDuplicated())
                answerSession.setMessage("Duplicated numbers, please select 4 different digits!\n");
            // If guees is valid
            else {
                String strGuess = userGuess.toString(); // Convert the guess to string
                // Add guess to the table row
                TableRow tableRow = new TableRow();
                tableRow.setGuess(strGuess);
                tableRow.handleGuess(answerSession.getAnswer());

                answerSession.setMessage(" Your guess: " + tableRow.getBulls() + " Bulls and " + tableRow.getCows() + " Cows");
                // Add table row to the Table
                tablSession.add(new TableRow(tableRow.getGuess(), tableRow.getBulls(), tableRow.getCows()));
                // Score ++
                winnerDetailsSession.setScore(winnerDetailsSession.getScore() + 1);
                // If guess = answer
                if (strGuess.equals(answerSession.getAnswer())) {
                    return "redirect:/won";
                }
            }
        }
        model.addAttribute("answer", answerSession.getAnswer());
        model.addAttribute("guess", userGuess);
        model.addAttribute("message",  answerSession.getMessage());
        model.addAttribute("tableRows", tablSession.getTable());
        return "index";
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