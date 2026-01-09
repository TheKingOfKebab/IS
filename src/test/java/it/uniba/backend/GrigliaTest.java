package it.uniba.backend;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 *Classe per testare la classe griglia.
 */
public class GrigliaTest {
/**
 *Parola segreta preimpostata.
 */
private static final String PAROLA_SEGRETA = "pesca";
/**
 *Array contenente un tentativo
 * dove la parola è esatta.
 */
private static final char[] TENTATIVO_GIUSTO = {'p', 'e', 's', 'c', 'a'};
/**
 *Array contenente un tentativo
 * dove la parola è sbagliata.
 */
private static final char[] TENTATIVO_SBAGLIATO = {'t', 'a', 'z', 'z', 'a'};
/**
 *Costante che indica il massimo
 * numero di tentativi.
 */
private static final int NUM_TENTATIVI_MAX = 6;
/**
 *Carattere presente nella parola
 *segreta nella posizione giusta.
 */
private static final char CARATTERE_GIUSTO = 'e';
/**
 *Carattere presente nella parola segreta
 *ma nella posizione sbagliata.
 */
private static final char CARATTERE_POSIZIONE_SBAGLIATA = 'a';
/**
 *costante che indica una colonna
 *della griglia.
 */
private static final int INDICE = 1;
/**
 *Indica la riga nella matrice griglia.
 */
private static final int RIGA_MATRICE = 1;

/**
 *Nuovo oggetto di tipo griglia.
 */
private static final Griglia GRIGLIA_TEST = new Griglia(
    PAROLA_SEGRETA, NUM_TENTATIVI_MAX);

    /**
    * Metodo che testa la corretta esecuzione
    * del metodo isInRightPosition.
    */
    @Test
    public void isInRightPositionTest() {
        assertEquals(true, GRIGLIA_TEST.isInRightPosition(
            CARATTERE_GIUSTO, TENTATIVO_GIUSTO, INDICE));
    }

    /**
    * Metodo che testa la corretta esecuzione
    * del metodo isInWrongPosition.
    */
    @Test
    public void isInWrongPositionTest() {
        assertEquals(true, GRIGLIA_TEST.
        isInWrongPosition(
            CARATTERE_POSIZIONE_SBAGLIATA, TENTATIVO_SBAGLIATO, RIGA_MATRICE));
    }
}


