package hac.controllers;

import hac.beans.WinnerDetails;
import hac.repo.WinnersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * debug Controller
 */
@RestController
@RequestMapping("/debug")
public class DebugController {

    /**
     * WinnersRepository
     */
    @Autowired
    private WinnersRepository repository;

    /**
     * Retrieves the list of winners.
     *
     * @return The list of WinnerDetails objects representing the winners.
     */
    @GetMapping("/winners")
    public List<WinnerDetails> showPurchases() {
        return repository.findAll();
    }
}
