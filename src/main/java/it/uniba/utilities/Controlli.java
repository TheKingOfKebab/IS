/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license.
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java
 * to edit this template.
 */

package it.uniba.utilities;

import it.uniba.backend.GameManager;

/**
 *
 * @author Antonio Pallara.
 *
 * La classe Controlli effettua controlli sul rispetto
 * dei vincoli da parte dell'input.
 *
 * La classe e' di tipo noECB.
 */
public final class Controlli {

    /**
     * LUNGHEZZA_PAROLA_SEGRETA definisce la lunghezza massima della parola.
     */
    private static final int LUNGHEZZA_PAROLA_SEGRETA = 5;

    /**
     * PAROLA_VUOTA contiene la lunghezza della parola vuota.
     */
    private static final int PAROLA_VUOTA = 0;
    private Controlli() {
        //not called
    }
    /**
     * @param parola
     * @return valore booleano,
     * true se la parola ha solo lettere,
     * false altrimenti.
     */
    public static boolean soloLettere(final String parola) {
        boolean allLetters = parola.matches("[a-zA-Z]+");
        if (!allLetters) {
            FrontEndManager.stampaMessaggioErroreParola();
        }
        return allLetters;
    }
    /**
     * @param tentativoParola
     * @return valore booleano
     * -true se la lunghezza della parola inserita e' pari alla
     * lunghezza della parola segreta
     * -false se la lunghezza non rispetta lo standard
     */
    public static boolean lunghezzaParola(final String tentativoParola) {
        if (tentativoParola.length() > LUNGHEZZA_PAROLA_SEGRETA) {
            FrontEndManager.stampaLunghezzaEccessiva();
            return false;
        } else if (tentativoParola.length() < LUNGHEZZA_PAROLA_SEGRETA) {
            FrontEndManager.stampaLunghezzaInsufficiente();
            return false;
        }
        return true;
    }
    /**
     * @param game sessione di gioco in corso
     * @return valore booleano
     * -true se la partita non e' in corso
     * -false se la partita e' avviata
     */
    public static boolean partitaNonInCorso(final GameManager game) {
        if (game.getEsecuzione()) {
            FrontEndManager.partitaInCorso();
            return false;
        }
        return true;
    }
    /**
     * @param parola
     * -se la parola segreta e' vuota avviso l'utente
     * -se la parola segreta non e' vuota l'aggiornamento e' andato a buon fine
     */
    public static void parolaSegretaVuota(final String parola) {
        if (parola.length() == PAROLA_VUOTA) {
            FrontEndManager.parolaSegretaInseritaVuota();
        } else {
            FrontEndManager.aggiornamentoParolaSegrataOk(parola);
        }
    }
}
