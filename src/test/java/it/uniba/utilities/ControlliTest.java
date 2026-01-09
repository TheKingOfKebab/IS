package it.uniba.utilities;
import it.uniba.backend.GameManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
/**
 * @author Flavio Valerio
 * classe per il testing della classe Controlli.
 */
public class ControlliTest {
    /**
     * parola troppo breve.
     */
    private static final String PAROLA_BREVE = "bre";
    /**
     * parola troppo lunga.
     */
    private static final String PAROLA_LUNGA = "lunghissima";
    /**
     * parola con numeri.
     */
    private static final String PAROLA_CON_NUMERI = "BREV3";
    /**
     * parla con simboli.
     */
    private static final  String PAROLA_SIMBOLI = "BREV!";
    /**
     * parola che rispetta i vincoli.
     */
    private static final String PAROLA_OK = "pesca";
    /**
     * obj GameManager sul quale la partita e' in esecuzione.
     */
    private final GameManager gameOn = new GameManager();
    /**
     * obj GameManager sul quale la partita non e' in esecuzione.
     */
    private final GameManager gameOff = new GameManager();
    /**
     * prima di iniziare il testing avvio la partita sul GameManager.
     */
    @BeforeEach
    public void setupGameInEsecuzione() {
        gameOn.iniziaPartita();
    }
    /**
     * Il test verifica se in caso di stringa avente al suo interno numeri,
     * "soloLettere" restuisca false.
     */
    @Test
    public void soloLettereTestConNumeri() {
        assertEquals(false, Controlli.soloLettere(PAROLA_CON_NUMERI));
    }
    /**
     * Il test verifica se in caso di stringa avente al suo interno simboli,
     * "soloLettere" restuisca false.
     */
    @Test
    public void soloLettereTestConSimboli() {
        assertEquals(false, Controlli.soloLettere(PAROLA_SIMBOLI));
    }
    /**
     * Il test verifica se in caso di stringa
     * avente al suo interno solo lettere,
     * "soloLettere" restuisca true.
     */
    @Test
    public void soloLettereTestSenzaNumeri() {
        assertEquals(true, Controlli.soloLettere(PAROLA_OK));
    }
    /**
     * il Test controlla se in caso di parola avente lunghezza breve,
     * il metodo "Lunghezza parola" restituisca false.
     */
    @Test
    public void lunghezzaParolaTestParolaCorta() {
      assertEquals(false, Controlli.lunghezzaParola(PAROLA_BREVE));
    }
    /**
     * il Test controlla se in caso di parola avente lunghezza troppo lunga,
     * il metodo "Lunghezza parola" restituisca false.
     */
    @Test
    public void lunghezzaParolaTestParolaLunga() {
        assertEquals(false, Controlli.lunghezzaParola(PAROLA_LUNGA));
    }
    /**
     * Il test controlla se in caso di parola avente lunghezza giusta,
     * il metodo "Lunghezza parola" restituisca true.
     */
    @Test
    public void lunghezzaParolaTestLunghezzaOK() {
        assertEquals(true, Controlli.lunghezzaParola(PAROLA_OK));
    }
    /**
     * Il test controlla se in caso di partita non in corso,
     * otteniamo da partitaNonInCorso, l'esito aspettato
     * cioe' true.
     */
    @Test
    public void partitaInCorsoTestOff() {
        assertEquals(true, Controlli.partitaNonInCorso(gameOff));
    }
    /**
     * Il test controlla se in caso di partita in corso,
     * otteniamo da partitaNonInCorso, l'esito aspettato
     * cioe' false.
     */
    @Test
    public void partitaInCorsoTestOn() {
        assertEquals(false, Controlli.partitaNonInCorso(gameOn));
    }
}
