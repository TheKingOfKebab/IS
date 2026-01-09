
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license.
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java
 * to edit this template.
 */
package it.uniba.utilities;

/**
 * La classe FrontEndManager si occupa di gestire tutte le stampe a schermo del
 * gioco, dal men? di avvio ai messaggi di errore.
 *
 * TIPOLOGIA DI CLASSE: Boundary.
 *
 *
 */
public final class FrontEndManager {

    /**
     * costruttore della classe FrontEndManager.
     */
    private FrontEndManager() {

    }

    /**
     * Stampa la scritta wordle in ASCII art.
     */
    public static void mostraMenuPrincipale() {
        System.out.format("%n%n                                              ____%n"
                + " ___   ___   ______   ______   ____    _     | ___|%n"
                + "|   |_|   | |  __  | |      | |  _ \\  | |    | |_%n"
                + "|    _    | | |  | | |  _  _| | | \\ \\ | |    |  _|%n"
                + "|   / \\   | | |__| | | | \\ \\  | |_/ / | |__  | |__%n"
                + "|__/   \\__| |______| |_|  \\_\\ |____/  |____| |____|");
    }

    /**
     * Stampa la lista dei comandi utili nel gioco.
     */
    public static void mostraAiuto() {
        System.out.format("%n%n      LISTA COMANDI%n");
        System.out.println("/nuova <parola> - ");
        System.out.print("per impostare una nuova parola segreta");
        System.out.println("/mostra - per vedere la parola segreta");
        System.out.println("/help - per visionare la lista dei comandi");
        System.out.println("/gioca - per avviare una nuova partita");
        System.out.println("/abbandona -per terminare una partita");
        System.out.println("/esci - per chiudere il gioco");
        System.out.print("<parola> - ");
        System.out.println("per inserire una parola durante una partita");
    }

    /**
     * Pulisce lo schermo da tutti gli elementi precedentemente stampati.
     */
    public static void pulisciSchermo() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Stampa un messaggio di vittoria del gioco.
     */
    public static void stampaMessaggioDiVittoria() {
        System.out.println("Complimenti hai vinto la partita :)");
    }

    /**
     * Stampa la parola segreta.
     * @param parolaSegreta
     */
    public static void stampaParolaSegreta(final String parolaSegreta) {
        System.out.println(parolaSegreta);
    }

    /**
     * Stampa un messaggio di comando errato.
     */
    public static void stampaMessaggioDiErrore() {
        System.out.println("Attenzione comando non valido !");
    }

    /**
     * Stampa un messaggio di sconfitta del gioco.
     * @param parolaSegreta
     */
    public static void stampaMessaggioDiSconfitta(final String parolaSegreta) {
        System.out.println("Tentativi terminati. La parola segreta era: ");
        System.out.print(parolaSegreta);
    }

    /**
     * Stampa un messaggio di parola insetita non valida.
     */
    public static void stampaMessaggioErroreParola() {
        System.out.print("Attenzione la parola inserita non è valida! ");
        System.out.println("La parola deve contenere solo lettere");
    }

    /**
     * Stampa un messagio di lunghezza parola eccessiva.
     */
    public static void stampaLunghezzaEccessiva() {
        System.out.println("La parola è troppo lunga. "
                + "Deve essere di esattamente "
                + "5 caratteri.");
    }

    /**
     * Stampa un messaggio ci lunghezza troppo corta.
     */
    public static void stampaLunghezzaInsufficiente() {
        System.out.println("La parola è troppo corta");
    }

    /**
     * Stampa un messaggio per la conferma dell'operazione scelta.
     */
    public static void stampaSeiSicuro() {

        System.out.println("Sei Sicuro? (si/no)");
    }

    /**
     *Stampa messaggio di errore nel caso in cui
     * un utente stampa una risposta diversa da si/no.
     */
    public static void stampaLaRispostaDeveEssereSiNo() {
        System.out.println("Risposta non valida. "
                 + "Perfavore scrivi \"si\" oppure \"no\"");
    }

    /**
     * Stampa messaggio di parola segreta non impostata.
     */
    public static void parolaSegretaVuota() {
        System.out.println("Non e' stata scelta ancora alcuna parola segreta");
    }

    /**
     * Stampa messaggio di comando errato durante una partita.
     */
    public static void partitaInCorso() {
        System.out.print("Il commando richiesto ");
        System.out.println("non puo' essere usato durante una partita!");
        System.out.print("Se si desidera usarlo, ");
        System.out.println("effettuare prima /abbandona");
    }

    /**
     * Stampa messaggio parola inserita è vuota.
     */
    public static void parolaSegretaInseritaVuota() {
        System.out.println("Non e' stata inserita alcuna parola segreta..");
        System.out.print("perfavore, dopo il ");
        System.out.println("comando /nuova scrivere una parola segreta");
        System.out.println("esempio: /nuova pesca");
    }

    /**
     * Stampa messaggio per corretto aggiornameto dalla parola segreta.
     * @param parola
     */
    public static void aggiornamentoParolaSegrataOk(final String parola) {
        System.out.print("Parola segreta aggiornata, ");
        System.out.println("nuova parola segreta: " + parola);
    }

    /**
     * Stampa un carattere su sfondo verde.
     * @param carattere
     */
    public static void scrivereCarattereInVerde(final char carattere) {
        System.out.print("\u001B[42m" + carattere + "\u001B[0m");
    }

    /**
     * Stampa un carattere su sfondo giallo.
     * @param carattere
     */
    public static void scrivereCarattereInGiallo(final char carattere) {
        System.out.print("\u001B[43m" + carattere + "\u001B[0m");
    }

    /**
     * Stampa un carattere su sfondo bianco.
     * @param carattere
     */
    public static void scrivereCarattereInBianco(final char carattere) {
        System.out.print("\u001B[47m" + carattere + "\u001B[0m");
    }

    /**
<<<<<<< HEAD:src/main/java/it/uniba/app/FrontEndManager.java
     * Stampa un messaggio di comando non presente nella lista dei comandi.
     */
    public static void scriviMessaggioComandoSconosciuto() {
        System.out.println("Il comando inserito non e' valido, "
                + "leggi la lista comandi");
    }

    /**
     * Stampa un messaggio di errore nel caso di sintassi errata di un comando.
     */
    public static void scriviMessaggioSintassiErrata() {
        System.out.println("Sintassi errata del comando");
    }

    /**
     * Stampa un messaggio di corretta configurazione della parola segreta.
     */
    public static void confermaInserimentoParolaSegreta() {
        System.out.println("La parola segreta e' impostata correttamente.");
        System.out.println("Ora puoi avviare una partita scrivendo '/gioca'");
    }
    /**
     * Stampa un messaggio di notifica del non avviamento di alcuna partita.
     */
       public static void errorePartitaNonAvviata() {
        System.out.println("Attenzione, non è stata avviata nessuna partita !");

    }
}
