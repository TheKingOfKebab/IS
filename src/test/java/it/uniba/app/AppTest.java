package it.uniba.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Main test class of the application.
 */
public class AppTest {
    /**
     * Test the getGreeting method of the App class.
     */
    @Test
    public void testSetGiocatoreVuoleContinuare() {
        App.setGiocatoreVuoleContinuare(true);
        assertEquals(true, App.getGiocatoreVuoleContinuare());
    }
}
