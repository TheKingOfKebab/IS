package it.uniba.exceptions;

public class ParserException extends Exception {

    /**
     * Messaggio di errore.
     */
    private static final String MESSAGGIO = "comando vuoto";

    /**
     * Costruttore.
     */
    public ParserException() {
        super(MESSAGGIO);
    }

}
