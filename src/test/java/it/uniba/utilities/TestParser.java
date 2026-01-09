package it.uniba.utilities;
import it.uniba.backend.GameManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import it.uniba.exceptions.ParserException;

public class TestParser {
    /**
     * Stringa vuota.
     */
    private static final String COMANDO_VUOTO = "";
    /**
     * Partita da testare.
     */
    private static final GameManager GAMEMANAGER = new GameManager();
    /**
     * Comando per iniziare una partita.
     */
    private static final String COMANDO_GIOCA = "/gioca";
    /**
    * istanza di una parola segreta.
    */
    private static final String PAROLA_SEGRETA = "cacao";
    /**
     * Comando Nuova <parola>.
     */
    private static final String COMANDO_NUOVA = "/nuova pippo";
    /**
     * nuova parola segreta.
     */
    private static final String NUOVA_PAROLA_SEGRETA = "pippo";

    /**
     * Scanner necessario per il parser.
     */
    private static final Scanner SCANNER = new Scanner(System.in, "UTF-8");

    /**
     * setup del obj GameManager, impostata la parola segreta "cacao".
     */
    @BeforeEach
    public void setupGameManager() {
        GAMEMANAGER.setParolaSegreta(PAROLA_SEGRETA);
    }

    /**
     * lo scan va chiuso al termine dei test.
     */
    @AfterAll
    public static void closeScanner() {
        SCANNER.close();
    }

    /**
     * il test controlla che il gioco risulti avere la partita in corso dopo
     * l'utilizzo del comando '/gioca'.
     */
    @Test
    public void testParseGiocoInEsecuzione() {
        try {
            Parser.parse(COMANDO_GIOCA, GAMEMANAGER, SCANNER);
            assertEquals(true, GAMEMANAGER.getEsecuzione());
        } catch (ParserException e) {
            assertEquals(false, GAMEMANAGER.getEsecuzione());
        }
    }

    /**
     * Il test controlla che la parolaSegreta venga cambiata correttamente
     * dal comando /nuova <parola>.
     */
    @Test
    public void testParseNuovaParola() {
        try {
            Parser.parse(COMANDO_NUOVA, GAMEMANAGER, SCANNER);
            assertEquals(NUOVA_PAROLA_SEGRETA, GAMEMANAGER.getParolaSegreta());
        } catch (ParserException e) {
            System.out.println(e.getMessage());
            //non dovrei essere in eccezione -> test fallito.
            fail();
        }
    }

    /**
     * Il test controlla che in caso di comando vuoto venga lanciata
     * l'eccezione aspettata.
     */
    @Test ()
    public void testEccezioneStringaVuota() {
        Exception exception = assertThrows(ParserException.class, () -> {
            Parser.parse(COMANDO_VUOTO, GAMEMANAGER, SCANNER);
        });

        String messaggioAspettato = "comando vuoto";
        String messaggioRicevuto = exception.getMessage();
        assertTrue(messaggioRicevuto.contains(messaggioAspettato));
    }

}
