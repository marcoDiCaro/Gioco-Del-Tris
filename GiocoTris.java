/* 3. ** Realizza il gioco del tris. L'interfaccia deve essere testuale (ovvero, visualizzata su console).
Il gioco deve essere in grado di determinare il vincitore della partita. **
# Es:
    Giocatore 1, fai la tua mossa!
       |   |
    -----------
       |   |
    -----------
       |   |
    Inserisci coordinate (X): 0,0
    Giocatore 2, fai la tua mossa!
     X |   |
    -----------
       |   |
    -----------
       |   |
    Inserisci coordinate (O): 1,1
    Giocatore 1, fai la tua mossa!
     X |   |
    -----------
       | O |
    -----------
       |   |
    *Etc...*
*/

import java.util.Arrays;
import java.util.Scanner;

public class GiocoTris {

    static Scanner myObj = new Scanner(System.in); // Create a Scanner object

    static int vittorieGiocatore1 = 0;
    static int vittorieGiocatore2 = 0;

    static void renderTris(String[][] strutturaTris) {
        for (int i = 0; i < strutturaTris.length; i++) {
            for (int j = 0; j < strutturaTris[i].length; j++) {
                if (j == strutturaTris[i].length - 1) {
                    System.out.println(strutturaTris[i][j]);
                } else {
                    System.out.print(strutturaTris[i][j] + " | ");
                }
            }
            if (i != strutturaTris.length - 1) {
                System.out.println("-----------");
            }
        }
    }

    static void controlloCordinate(String coordinate, String valore, String[][] strutturaTris) {
        String regex = "^[0-2],[0-2]$";

        if (!coordinate.matches(regex)) {
            System.out.println("La riga e la colonna devono avere un valore compreso tra 0 e 2.");
            System.out.println("Inserisci nuove coordinate:");
            String coordinateGiocatore = myObj.nextLine();
            controlloCordinate(coordinateGiocatore, valore, strutturaTris);
        }

        int riga = Character.getNumericValue(coordinate.charAt(0));

        /*
         * if (riga < 0 || riga > 2) {
         * throw new
         * IllegalArgumentException("La riga deve avere un valore compreso tra 0 e 2.");
         * }
         */

        int colonna = Character.getNumericValue(coordinate.charAt(2));

        /*
         * if (colonna < 0 || colonna > 2) {
         * throw new
         * IllegalArgumentException("La colonna deve avere un valore compreso tra 0 e 2."
         * );
         * }
         */

        if (strutturaTris[riga][colonna].equals(" ")) {
            aggiungiCoordinate(riga, colonna, valore, strutturaTris);
        } else {
            System.out.println("Inserisci nuove coordinate perchè casella già occupata:");
            String coordinateGiocatore = myObj.nextLine();
            controlloCordinate(coordinateGiocatore, valore, strutturaTris);
        }

    }

    static void aggiungiCoordinate(int riga, int colonna, String valore, String[][] strutturaTris) {
        strutturaTris[riga][colonna] = valore;
    }

    static boolean controlloVincitore(String[][] strutturaTris, String valore) {
        String giocatore = (valore.equals("X")) ? "Giocatore 1" : "Giocatore 2";
        for (int i = 0; i < 3; i++) {
            // Controllo sulle colonne
            if (strutturaTris[0][i].equals(valore) && strutturaTris[1][i].equals(valore)
                    && strutturaTris[2][i].equals(valore)) {
                System.out.println(String.format("%s ha vinto la partita", giocatore));
                if (giocatore.equals("Giocatore 1")) {
                    vittorieGiocatore1++;
                } else {
                    vittorieGiocatore2++;
                }
                return true;
            }
            // Controllo sulle righe
            if (strutturaTris[i][0].equals(valore) && strutturaTris[i][1].equals(valore)
                    && strutturaTris[i][2].equals(valore)) {
                System.out.println(String.format("%s ha vinto la partita", giocatore));
                if (giocatore.equals("Giocatore 1")) {
                    vittorieGiocatore1++;
                } else {
                    vittorieGiocatore2++;
                }
                return true;
            }
        }
        // Controllo sulle diagonali
        if (strutturaTris[0][0].equals(valore) && strutturaTris[1][1].equals(valore)
                && strutturaTris[2][2].equals(valore)) {
            System.out.println(String.format("%s ha vinto la partita", giocatore));
            if (giocatore.equals("Giocatore 1")) {
                vittorieGiocatore1++;
            } else {
                vittorieGiocatore2++;
            }
            return true;
        }
        if (strutturaTris[0][2].equals(valore) && strutturaTris[1][1].equals(valore)
                && strutturaTris[2][0].equals(valore)) {
            System.out.println(String.format("%s ha vinto la partita", giocatore));
            if (giocatore.equals("Giocatore 1")) {
                vittorieGiocatore1++;
            } else {
                vittorieGiocatore2++;
            }
            return true;
        }
        return false;
    }

    static void giocoTris() {

        System.out.println(String.format("Numero vittorie Giocatore 1: %d", vittorieGiocatore1));
        System.out.println(String.format("Numero vittorie Giocatore 2: %d", vittorieGiocatore2));
        
        int righe = 3;
        int colonne = 3;
        String[][] strutturaTris = new String[righe][colonne];

        for (String el[] : strutturaTris) {
            Arrays.fill(el, " ");
        }

        renderTris(strutturaTris);

        for (int i = 1; i <= righe * colonne; i++) {
            String valore = "";
            if (i % 2 != 0) {
                valore = "X";
                System.out.println("Giocatore 1, fai la tua mossa!");
                System.out.println("Inserisci coordinate (X):");
            } else {
                valore = "O";
                System.out.println("Giocatore 2, fai la tua mossa!");
                System.out.println("Inserisci coordinate (0):");
            }

            String coordinateGiocatore = myObj.nextLine();

            controlloCordinate(coordinateGiocatore, valore, strutturaTris);

            renderTris(strutturaTris);

            if (i >= 3) {
                boolean esito = controlloVincitore(strutturaTris, valore);
                if (esito) {
                    break;
                }
            }

            if (i == righe * colonne) {
                System.out.println("La partita è finita in pareggio!");
            }

        }

        System.out.println("Rigiocare?");

        String rigioca = myObj.nextLine();

        if (rigioca.toLowerCase().equals("si")) {
            giocoTris();
        }

        myObj.close();
    }

    public static void main(String[] args) {
        giocoTris();
    }
}
