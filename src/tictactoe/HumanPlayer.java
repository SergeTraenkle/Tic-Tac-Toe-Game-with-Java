package tictactoe;

import java.util.Scanner;

public class HumanPlayer extends AbstractPlayer {
    public HumanPlayer(String name, Symbol symbol) { // Konstruktor
        super(symbol, name);
    }

    @Override
    public boolean isHuman() {
        return true;
    }

    @Override
    public void makeMove(Board board) { // besser: decideMove (board) Entscheidung
        // Eingabe über Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte Zeile eingeben (0-2): ");
        int row = scanner.nextInt(); // Eingabe für Zeile
        System.out.println("Bitte Spalte eingeben (0-2): ");
        int col = scanner.nextInt(); // Eingabe für Spalte
        
        while (!board.makeMove(row, col, symbol)) { // solange das Feld nicht frei (false)
            System.out.println("Ungültiger Zug. Bitte erneut versuchen.");
            row = scanner.nextInt(); // Weitere Eingabe für Zeile
            col = scanner.nextInt(); // Weitere Eingabe für Spalte
        }
    }
}
 