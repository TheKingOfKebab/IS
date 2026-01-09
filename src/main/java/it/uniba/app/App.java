package it.uniba.app;
import it.uniba.utilities.FrontEndManager;
import it.uniba.backend.GameManager;
import it.uniba.utilities.Parser;
import java.util.Scanner;
import it.uniba.exceptions.ParserException;
/**
 * Main class of the application.
 */
public final class App {
    /**
     *flag usato per interrompere la partita.
     */
    private static boolean giocatoreVuoleContinuare = true;

    /**
     * Default constructor.
    */
    private App() {
        //not called.
    }

    /**
     *Setta il valore della variabile: giocatoreVuoleContinuare.
     * @param valore il valore a cui settarlo.
     */
    public static void setGiocatoreVuoleContinuare(final boolean valore) {
        giocatoreVuoleContinuare = valore;
    }

    /**
     *Prendi il valore della variabile: giocatoreVuoleContinuare.
     *@return restituisce se il giocatore vuole continuare.
     */
    public static boolean getGiocatoreVuoleContinuare() {
        return giocatoreVuoleContinuare;
    }

    private static void chiamaParser(
        final String input, final GameManager partita,
        final Scanner scan) {
        try {
            Parser.parse(input, partita, scan);
        } catch (ParserException e) {
            System.out.println("Digitare qualcosa...");
        }
    }

    /**
     * Entrypoint of the application.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {

        GameManager partita = new GameManager();

        FrontEndManager.mostraMenuPrincipale();
        FrontEndManager.mostraAiuto();

        Scanner scan = new Scanner(System.in, "UTF-8");
        String input = "";
        while (giocatoreVuoleContinuare) {
            System.out.println("\nInserisci uno dei comandi: \n");
            input = scan.nextLine();
            chiamaParser(input, partita, scan);
        }
        scan.close();
        System.exit(0);
    }
}
