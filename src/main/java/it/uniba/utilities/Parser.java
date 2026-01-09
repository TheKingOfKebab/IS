/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java
 * to edit this template
 */
package it.uniba.utilities;
import it.uniba.exceptions.ParserException;
import it.uniba.backend.GameManager;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Flavio Valerio La classe Parser si occupa di interpretare l'input
 * dell'utente, e capire come gestire il flusso del programma di conseguenza.
 *
 * 
 */
public final class Parser {

    private Parser() {
        //not called
    }

    /**
     *Elabora i comandi in input.
     * @param comando input digitato dall'utente.
     * @param game partita in corso.
     * @param scanner lo scanner per leggere l'input.
     */
    public static void parse(
        final String comando, final GameManager game,
         final Scanner scan)  throws ParserException {
        Pattern pattern = Pattern.compile("\\S+");
        Matcher matcher = pattern.matcher(comando);
        boolean trovaSpazio = matcher.find();
        if (comando.length() == 0) {
            throw new ParserException();
        }
        if (matcher.group().equalsIgnoreCase("/nuova") && trovaSpazio) {

            if (Controlli.partitaNonInCorso(game) && matcher.find()) {
                int contaParole = 1;
                if (matcher.find() == true) {

                    contaParole++;

                }

                matcher.reset();
                matcher.find();
                matcher.find();

                if (Controlli.soloLettere(matcher.group()) 
                    && Controlli.lunghezzaParola(matcher.group()) 
                    && contaParole == 1) {

                    game.setParolaSegreta(matcher.group());
                    game.setParolaSegreta(matcher.group());
                    FrontEndManager.confermaInserimentoParolaSegreta();
                } else {
                    FrontEndManager.scriviMessaggioSintassiErrata();
                }

            } else {

                FrontEndManager.parolaSegretaVuota();

            }
        } else if (matcher.group().equals("/mostra")) {
            if (Controlli.partitaNonInCorso(game)) {
                if (game.getParolaSegreta().length() != 0) {
                    FrontEndManager.
                            stampaParolaSegreta(game.getParolaSegreta());
                } else {
                    FrontEndManager.parolaSegretaVuota();
                }
            }
        } else if (matcher.group().equals("/help")
                || (matcher.group().equals("/h"))
                || (matcher.group().equals("-h"))
                || (matcher.group().equals("--help"))) {
            FrontEndManager.mostraAiuto();
        } else if (matcher.group().equals("/gioca")) {
            if (!game.getEsecuzione() && !game.getParolaSegreta().isEmpty()) {
                game.iniziaPartita();
            } else if (game.getEsecuzione()) {
                Controlli.partitaNonInCorso(game);
            } else {
                FrontEndManager.parolaSegretaVuota();
            }
        } else if (matcher.group().equals("/abbandona")) {

            if (!game.getEsecuzione()) {
                FrontEndManager.errorePartitaNonAvviata();
            } else {
                String risposta;
                boolean flag = true;

                do {
                    FrontEndManager.stampaSeiSicuro();
                    risposta = scan.nextLine();
                    risposta = risposta.toLowerCase();

                    if (risposta.equals("si")) {
                        game.abbandonaPartita();
                        flag = false;
                    } else if (risposta.equals("no")) {
                        flag = false;
                    } else {
                        FrontEndManager.stampaLaRispostaDeveEssereSiNo();
                    }
                } while (flag);
            }

        } else if (matcher.group().equals("/esci")) {
            String risposta;
            boolean flag = true;
            do {
                FrontEndManager.stampaSeiSicuro();
                risposta = scan.nextLine();
                risposta = risposta.toLowerCase();

                if (risposta.equals("si")) {
                    game.esciPartita();
                    flag = false;
                } else if (risposta.equals("no")) {
                    flag = false;
                } else {
                    FrontEndManager.stampaLaRispostaDeveEssereSiNo();
                }

            } while (flag);

            //tentativo
        } else if (game.getEsecuzione()
                && Controlli.soloLettere(comando)
                && Controlli.lunghezzaParola(comando)) {

            game.inserisciNuovoTentativo(comando);

        } else if (!game.getEsecuzione()) {
            FrontEndManager.scriviMessaggioComandoSconosciuto();
        }
    }
}
