package it.uniba.backend;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
/**
 * @author Aldo Mangione
 * Classe per il testing della classe GameManager.
 */
public class GameManagerTest {
    /**
     *parola segreta test.
     */
    private static final String PAROLA_SEGRETA = "cacao";

    /**
     *tentativo test.
     */
    private static final String TENTATIVO = "hotel";
    /**
     *costante per il numero di tentativi.
     */
    private static final int TENTATIVO_MAX = 6;
    /**
     *istanza test di GameManager.
     */
    private static final GameManager GAMEMANAGER = new GameManager();
    /**
     *setup dell'istanza di GameManager,
     con partita avviata e parola segreta impsotata.
     */
    @BeforeEach
    public void setupGame() {
        GAMEMANAGER.iniziaPartita();
        GAMEMANAGER.setParolaSegreta(PAROLA_SEGRETA);
    }
    /**
     * Il testcontrolla se in caso di gamemanager con partita in esecuzione,
     * chiamato il metodo che ci dice se la partita e' in esecuzione,
     * questo restituisce true.
     */
    @Test
    public void testGetEsecuzione() {
        assertEquals(true, GAMEMANAGER.getEsecuzione());
    }
    /**
     *testa il metodo getParolaSegreta.
     */
    @Test
    public void testSetParolaSegreta() {
        assertEquals(PAROLA_SEGRETA, GAMEMANAGER.getParolaSegreta());
    }
    /**
     *testa il metodo abbandonaPartita.
     */
    @Test
    public void testAbbandonaPartita() {
        GAMEMANAGER.abbandonaPartita();
        assertEquals(false, GAMEMANAGER.getEsecuzione());
    }
    /**
     *testa il metodo InserisciNuovoTentativo.
     */
    @Test
    public void testInserisciNuovoTentativo() {
       GAMEMANAGER.iniziaPartita();
       GAMEMANAGER.setTentativoCorrente(TENTATIVO_MAX);
       GAMEMANAGER.inserisciNuovoTentativo(TENTATIVO);
       assertEquals(false, GAMEMANAGER.getEsecuzione());
    }
}
