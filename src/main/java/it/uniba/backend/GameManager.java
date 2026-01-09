package it.uniba.backend;

import it.uniba.app.App;
import it.uniba.utilities.FrontEndManager;

/**
 * La classe GameManager si occupa della logica di una partita di wordle: avvia
 * e ferma le partite, controlla i tentativi, gestisce le parole segrete... La
 * classe è di tipo Control.
 */
public class GameManager {
/**
*parolaSegreta contiene la parola segreta.
*/
    private String parolaSegreta;
/**
*numTentaviviMax contiene il numero massimo
*dei tentativi che si possono effettuare.
*/
    private static final int NUM_TENTATIVI_MAX = 6;
/**
*tentativoCorrente tiene conto del tentativo corrente.
*/
private int tentativoCorrente = 0;
/**
 * Setter per tentativo corrente.
 * @param tentativoAttuale il valore a cui impostarlo.
 */
public void setTentativoCorrente(final int tentativoAttuale) {
    this.tentativoCorrente = tentativoAttuale;
}
/**
 * Getter per tentativo corrente.
 * @return il valore di tentativo corrente.
 */
public int getTentativoCorrente() {
    return tentativoCorrente;
}

/**
*esecuzione tiene conto se si stagiocando o meno.
*/
    private boolean esecuzione;
/**
*grigliaPartitaCorrente è una nuova griglia di gioco.
*/
   private Griglia grigliaPartitaCorrente;
/**
*GameManager è un costruttore che reinizializza la partita.
*/
    public GameManager() {
        parolaSegreta = "";
        tentativoCorrente = 0;
        esecuzione = false;
    }
/**
*iniziaPartita crea una griglia di gioco
*con le impostazioni settate da GameManager.
*/
    public void iniziaPartita() {
        tentativoCorrente = 0;

        esecuzione = true;
        grigliaPartitaCorrente = new Griglia(parolaSegreta, NUM_TENTATIVI_MAX);
        grigliaPartitaCorrente.stampaGriglia(parolaSegreta);
    }
/**
*getEsecuzione restituisce se la partita
* è già stata avviata o no.
*@return esecuzione
*/
    public boolean getEsecuzione() {
        return this.esecuzione;
    }
/**
*getGrigliaCorrente restituisce
*la griglia corrente della partita.
*@return grigliaPartitaCorrente
*/
    public Griglia getGrigliaCorrente() {
        return grigliaPartitaCorrente;
    }
/**
*setParolaSegreta imposta la parola segreta.
*@param parola
*/
    public void setParolaSegreta(final String parola) {

        this.parolaSegreta = parola;

    }
/**
*abbandonaPartita permette di abbandonare una istanza di gioco.
*/
    public void abbandonaPartita() {
        esecuzione = false;
        FrontEndManager.mostraMenuPrincipale();
    }
/**
*esciPartita permette di uscire dal  gioco.
*/
    public void esciPartita() {
        App.setGiocatoreVuoleContinuare(false);
    }
/**
*inserisciNuovoTentativo incrementa il contatore
*dei tentativi effettuati (tentativoCorrente).
*@param tentativo
*/
    public void inserisciNuovoTentativo(final String tentativo) {

        tentativoCorrente++;

        grigliaPartitaCorrente.inserisciParola(tentativo);
        grigliaPartitaCorrente.stampaGriglia(parolaSegreta);

        if (tentativo.equals(parolaSegreta)) {

            FrontEndManager.stampaMessaggioDiVittoria();
            abbandonaPartita();

        } else if (tentativoCorrente >= NUM_TENTATIVI_MAX) {

            FrontEndManager.stampaMessaggioDiSconfitta(parolaSegreta);
            abbandonaPartita();
        }
    }
/**
*getParolaSegreta restituisce la parola segreta.
*@return parolaSegreta
*/
    public String getParolaSegreta() {
        return this.parolaSegreta;
    }
}
