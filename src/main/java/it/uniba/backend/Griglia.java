package it.uniba.backend;


/**
 * Questa classe si occupa di gestire la griglia di gioco che verrà mostrata a
 * schermo, dove tale griglia conterr? le lettera della parola inserita.
 * TIPOLOGIA CLASSE: Boundary.
 */
public class Griglia {

    /**
     * Larghezza della griglia.
     */
    private int dim1;
    /**
     * Altezza della griglia.
     */
    private int dim2;
    /**
     * La griglia viene considerata una matrice di caratteri.
     */
    private char[][] griglia;
    /**
     * tentativoCorrente serve a tener conto di quanti tentativi
     * ha fatto il giocatore.
     */
    private int tentativoCorrente = 0;

    /**
     *Costruttore Griglia.
     * @param parolaSegreta
     * @param numeroTentativi
     */
    public Griglia(final String parolaSegreta, final int numeroTentativi) {
        dim1 = numeroTentativi;
        dim2 = parolaSegreta.length();
        griglia = new char[dim1][dim2];
        inizializzaGriglia();

    }

    /**
     *
     */
    public void inizializzaGriglia() {
        for (int i = 0; i < dim1; i++) {
            for (int j = 0; j < dim2; j++) {
                griglia[i][j] = '\u2337';
            }
        }
    }

    /**
     *
     * @param parola
     */
    public void inserisciParola(final String parola) {
        if (tentativoCorrente <= dim1) {
            char[] vettoreParola = parola.toCharArray();

            for (int i = 0; i < dim2; i++) {
                griglia[tentativoCorrente][i] = vettoreParola[i];
            }

            tentativoCorrente++;
        }
    }

    /**
     * Stampa un carattere di colore verde.
     *
     * @param carattere
     */
    public static void scrivereCarattereInVerde(final char carattere) {
        System.out.print("\u001B[42m" + carattere + "\u001B[0m");
    }

    /**
     * Stampa un carattere di colore giallo.
     *
     * @param carattere
     */
    public static void scrivereCarattereInGiallo(final char carattere) {
        System.out.print("\u001B[43m" + carattere + "\u001B[0m");
    }

    /**
     * Stampa un carattere di colore bianco.
     *
     * @param carattere
     */
    public static void scrivereCarattereInBianco(final char carattere) {
        System.out.print("\u001B[47m" + carattere + "\u001B[0m");
    }

    /**
     * Stampa la griglia a schermo.
     *
     * @param parolaSegreta
     */
    public void stampaGriglia(final String parolaSegreta) {
        for (int i = 0; i < dim1; i++) {
            char[] parolaSegretadoppie = parolaSegreta.toCharArray();

            for (int j = 0; j < dim2; j++) {
                if (isInRightPosition(griglia[i][j], parolaSegretadoppie, j)) {
                    Griglia.scrivereCarattereInVerde(griglia[i][j]);
                } else if (isInWrongPosition(griglia[i][j], parolaSegretadoppie,
                        i)) {
                    Griglia.scrivereCarattereInGiallo(griglia[i][j]);
                } else {
                    Griglia.scrivereCarattereInBianco(griglia[i][j]);
                }
            }
            System.out.format("%n");
        }
    }

    /**
     * Controlla che il carattere sia in posizione giusta rispetto alla parola
     * segreta.
     *
     * @param carattere
     * @param vettoreParola
     * @param posizionePuntatoreColonna
     * @return l'esito del controllo.
     */
    public boolean isInRightPosition(final char carattere,
            final char[] vettoreParola, final int posizionePuntatoreColonna) {
        if (vettoreParola[posizionePuntatoreColonna] == carattere) {
            return true;
        }

        return false;
    }

    /**
     * Controlla se il carattere dato in input, in posizione sbagliata ma �
     * contenuta all'interno della parola vettore parola.
     * @param carattere
     * @param vettoreParola
     * @param rigaMatrice
     * @return restituisce l'esito del controllo.
     */
    public boolean isInWrongPosition(final char carattere,
            final char[] vettoreParola, final int rigaMatrice) {
        boolean esito = false;

        for (int i = 0; i < dim2; i++) {
            if (vettoreParola[i] == carattere
                    && griglia[rigaMatrice][i] != vettoreParola[i]) {
                vettoreParola[i] = '/';
                esito = true;
                return esito;
            }
        }
        return esito;
    }

}
