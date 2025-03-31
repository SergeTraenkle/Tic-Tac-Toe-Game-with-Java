package tictactoe;

public class Board {
    private Symbol[][] board; // 2D-Array [Zeilen/row] [Spalten/col] vom Typ Symbol

    public Board() { // Konstruktor
        board = new Symbol[GameConfig.BOARD_SIZE][GameConfig.BOARD_SIZE];
        // Initialisiere das Spielfeld mit leeren Feldern
        for (int row = 0; row < GameConfig.BOARD_SIZE; row++) {
            for (int col = 0; col < GameConfig.BOARD_SIZE; col++) {
                board[row][col] = Symbol.LEER;
            }
        }
    }

    public boolean makeMove(int row, int col, Symbol symbol) { // besser: applyMove. Anwendung
        // Überprüfe, ob das Feld frei ist.
        if (board[row][col] == Symbol.LEER) {
            board[row][col] = symbol;
            return true; // wenn das Feld frei
        }
        return false; // wenn das Feld nicht frei
    }

    public void printBoard() { // druckt etweder "-" oder board[row][col] aus
        System.out.println("-------------");
        for (int row = 0; row < GameConfig.BOARD_SIZE; row++) {
            System.out.print("| ");
            for (int col = 0; col < GameConfig.BOARD_SIZE; col++) {
                if (board[row][col] == Symbol.LEER) {
                    System.out.print("- | ");
                } else {
                    System.out.print(board[row][col] + " | "); 
                }
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public boolean checkWin(Symbol symbol) { // Gewonnen: 3 Mal X oder 3 Mal O => true ?
        // Überprüfe Zeilen
        for (int row = 0; row < GameConfig.BOARD_SIZE; row++) {
            if (board[row][0] == symbol && board[row][1] == symbol && board[row][2] == symbol) {
                return true;
            }
        }
        // Überprüfe Spalten
        for (int col = 0; col < GameConfig.BOARD_SIZE; col++) {
            if (board[0][col] == symbol && board[1][col] == symbol && board[2][col] == symbol) {
                return true;
            }
        }
        // Überprüfe Diagonalen
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }
        return false;
    }

    public boolean isFull() { // Board gefüllt? (Ja = true/Nein = false )
        for (int row = 0; row < GameConfig.BOARD_SIZE; row++) {
            for (int col = 0; col < GameConfig.BOARD_SIZE; col++) {
                if (board[row][col] == Symbol.LEER) {
                    return false;
                }
            }
        }
        return true;
    }
}

