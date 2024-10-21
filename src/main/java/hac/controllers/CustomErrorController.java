package hac.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Custom Error Controller to handle error pages in the application.
 */
@Controller
public class CustomErrorController implements ErrorController {

    /**
     * Handles the error page mapping.
     *
     * @return The name of the error view template.
     */
    @RequestMapping("/error")
    public String handleError() {
        return "error";
    }
}
