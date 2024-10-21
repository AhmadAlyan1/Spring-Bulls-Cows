package hac;

import hac.beans.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

/**
 * BeanConfiguration
 */
@Configuration
public class BeanConfiguration {

    /**
     * Defines a session-scoped bean for storing the answer.
     *
     * @return An instance of the Answer bean.
     */
    @Bean
    @SessionScope
    public Answer sessionAnswer() { return new Answer(); }

    /**
     * Defines a session-scoped bean for storing the table.
     *
     * @return An instance of the Table bean.
     */
    @Bean
    @SessionScope
    public Table sessionTable () { return new Table(); }

    /**
     * Defines a session-scoped bean for storing the winner details.
     *
     * @return An instance of the WinnerDetails bean.
     */
    @Bean
    @SessionScope
    public WinnerDetails sessionWinnerDetails () {
        return new WinnerDetails();
    }
}
